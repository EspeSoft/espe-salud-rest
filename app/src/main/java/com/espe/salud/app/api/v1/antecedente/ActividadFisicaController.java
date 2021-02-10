package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.ActividadFisicaDTO;
import com.espe.salud.service.antecedente.ActividadFisicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ACT_FIS;

@RestController
@Tag(name = "Gestiona los Atividad Fisica")
@RequestMapping(value = {URI_API_V1_ACT_FIS})
public class ActividadFisicaController {
    private final ActividadFisicaService actividadFisicaService;

    @Autowired
    public ActividadFisicaController(ActividadFisicaService actividadFisicaService) {
        this.actividadFisicaService = actividadFisicaService;
    }

    @Operation(summary = "Retorna el listado de todas las actividades fisicas")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ActividadFisicaDTO>> getAll() {
        return new ResponseEntity<>( actividadFisicaService.findAll(), HttpStatus.OK);
    }


    @Operation(summary = "Retorna una Actividad Física por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActividadFisicaDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity( actividadFisicaService.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita una actividead física  por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActividadFisicaDTO> update(@RequestBody ActividadFisicaDTO actividadFisicaDTO, @RequestParam Long codigo) {
        Optional<ActividadFisicaDTO> newActividadFisicaDTOoptional = actividadFisicaService.findByCodigo(codigo);
        ActividadFisicaDTO newActividadFisicaDTO = newActividadFisicaDTOoptional.get();
        newActividadFisicaDTO.setNombreActividad(actividadFisicaDTO.getNombreActividad());
        newActividadFisicaDTO.setFrecuencia(actividadFisicaDTO.getFrecuencia());
        newActividadFisicaDTO.setHoras(actividadFisicaDTO.getHoras());
        newActividadFisicaDTO.setObservacion(actividadFisicaDTO.getObservacion());
        return new ResponseEntity<>(actividadFisicaService.update(newActividadFisicaDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda una nueva Actividad Fisica ")
    @PostMapping("/")
    public ResponseEntity<ActividadFisicaDTO> save(@RequestBody ActividadFisicaDTO actividadFisica){
        return new ResponseEntity<>(actividadFisicaService.save(actividadFisica), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una Actividad Fisica por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        actividadFisicaService.delete(codigo);
    }

}
