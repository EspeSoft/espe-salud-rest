package com.espe.salud.app.api.v1.odontologia;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAR;

import com.espe.salud.domain.entities.odontologia.*;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.dto.odontologia.*;
import com.espe.salud.service.GenericCRUDService;
import com.espe.salud.service.odontologia.GenericCRUDServiceOdontograma;
import com.espe.salud.service.odontologia.HistoriaClinicaOdontologicaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import static com.espe.salud.app.common.Constants.URI_API_V1_ODO_ODO;

@RestController
@RequestMapping(value = {URI_API_V1_ODO_ODO})
@Tag(description = "Gestiona los detalles del odontograma como items individuales", name = "Detalles de odontograma")

public class DetalleOdontogramaController {

    private final GenericCRUDServiceOdontograma<DetalleOdontogramaCuantitativo, DetalleOdontogramaCuantitativoDTO> detalleCuantitativoService;

    private final GenericCRUDServiceOdontograma<DetalleOdontogramaSimple, DetalleOdontogramaSimpleDTO> detalleSimpleService;

    private final GenericCRUDServiceOdontograma<DetalleOdontogramaCompuesto, DetalleOdontogramaCompuestoDTO> detalleCompuestoService;

    private final HistoriaClinicaOdontologicaService historiaClinicaOdontologicaService;


    @Autowired
    public DetalleOdontogramaController(
            @Qualifier("detalleOdontogramaCuantitativoServiceImpl") GenericCRUDServiceOdontograma<DetalleOdontogramaCuantitativo, DetalleOdontogramaCuantitativoDTO> detalleCuantitativoService,
            @Qualifier("detalleOdontogramaSimpleServiceImpl") GenericCRUDServiceOdontograma<DetalleOdontogramaSimple, DetalleOdontogramaSimpleDTO> detalleSimpleService,
            @Qualifier("detalleOdontogramaCompuestoServiceImpl")GenericCRUDServiceOdontograma<DetalleOdontogramaCompuesto, DetalleOdontogramaCompuestoDTO> detalleCompuestoService,
            HistoriaClinicaOdontologicaService historiaClinicaOdontologicaService) {
        this.detalleCuantitativoService = detalleCuantitativoService;
        this.detalleSimpleService = detalleSimpleService;
        this.detalleCompuestoService = detalleCompuestoService;
        this.historiaClinicaOdontologicaService = historiaClinicaOdontologicaService;
    }


    @Operation(summary = "Retorna todos los detalles del odontograma")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DetalleOdontogramaDTO>> retrieve(@RequestParam Long idPaciente) {

        List<DetalleOdontogramaDTO> detalles = new ArrayList<>();

        Optional<HistoriaClinicaOdontologicaDTO> historiaExistente = historiaClinicaOdontologicaService.findByPaciente(idPaciente);
        if(historiaExistente.isPresent()) {
            detalles.addAll(detalleCuantitativoService.findByHistoriaClinica(historiaExistente.get().getId()));
            detalles.addAll(detalleSimpleService.findByHistoriaClinica(historiaExistente.get().getId()));
            detalles.addAll(detalleCompuestoService.findByHistoriaClinica(historiaExistente.get().getId()));
            return new ResponseEntity<>( detalles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    @Operation(summary = "Elimina los detalles anteriores y guarda los nuevos")
    public ResponseEntity<List<Object>> save(@RequestBody List<Object> detalles, @RequestParam Long idPaciente) {
        Optional<HistoriaClinicaOdontologicaDTO> historiaExistente = historiaClinicaOdontologicaService.findByPaciente(idPaciente);
        ObjectMapper objectMapper = new ObjectMapper();
        if (historiaExistente.isPresent()) {
            Long historiaID = historiaExistente.get().getId();
            List<DetalleOdontogramaSimple> detallesSimples = new ArrayList<DetalleOdontogramaSimple>();
            List<DetalleOdontogramaCompuesto> detallesCompuestos = new ArrayList<DetalleOdontogramaCompuesto>();
            List<DetalleOdontogramaCuantitativo> detallesCuantitativos = new ArrayList<DetalleOdontogramaCuantitativo>();

            // Transformar lista a objetos
            ListIterator<Object> iteratorDetalles = detalles.listIterator();
            while (iteratorDetalles.hasNext()) {
                try {
                    String jsonString = objectMapper.writeValueAsString(iteratorDetalles.next());
                    DetalleOdontogramaSimple detalleSimple = this.tryParse(objectMapper, jsonString, DetalleOdontogramaSimple.class);
                    if (detalleSimple != null) {
                        detalleSimple.setHistoriaId(historiaID);
                        detallesSimples.add(detalleSimple);
                    } else {
                        DetalleOdontogramaCompuesto detalleCompuesto = this.tryParse(objectMapper, jsonString, DetalleOdontogramaCompuesto.class);
                        if(detalleCompuesto != null) {
                            detalleCompuesto.setHistoriaId(historiaID);
                            detallesCompuestos.add(detalleCompuesto);
                        } else {
                            DetalleOdontogramaCuantitativo detalleCuantitativo = this.tryParse(objectMapper, jsonString, DetalleOdontogramaCuantitativo.class);
                            if(detalleCuantitativo != null) {
                                detalleCuantitativo.setHistoriaId(historiaID);
                                detallesCuantitativos.add(detalleCuantitativo);
                            }
                        }
                    }
                } catch (JsonProcessingException  e) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }


            // Eliminar detalles anteriores
            detalleSimpleService.deleteByHistoriaClinica(historiaID);
            detalleCompuestoService.deleteByHistoriaClinica(historiaID);
            detalleCuantitativoService.deleteByHistoriaClinica(historiaID);

            // Agregar nuevos detalles
            ListIterator<DetalleOdontogramaSimple> iteratorSimple = detallesSimples.listIterator();
            while(iteratorSimple.hasNext()) {
                detalleSimpleService.saveOrUpdate(detalleSimpleService.build(iteratorSimple.next()));
            }

            ListIterator<DetalleOdontogramaCompuesto> iteratorCompuesto = detallesCompuestos.listIterator();
            while(iteratorCompuesto.hasNext()) {
                detalleCompuestoService.saveOrUpdate(detalleCompuestoService.build(iteratorCompuesto.next()));
            }

            ListIterator<DetalleOdontogramaCuantitativo> iteratorCuantitativo = detallesCuantitativos.listIterator();
            while(iteratorCuantitativo.hasNext()) {
                detalleCuantitativoService.saveOrUpdate(detalleCuantitativoService.build(iteratorCuantitativo.next()));
            }
            return new ResponseEntity<>(detalles,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(detalles,HttpStatus.NOT_FOUND);
        }
    }


    private <T> T tryParse(ObjectMapper mapper, String jsonObject, Class<T> clazz)
    {
        try {
            return mapper.readValue(jsonObject, clazz);
        } catch (Exception ex) {
            return null;
        }
    }

}
