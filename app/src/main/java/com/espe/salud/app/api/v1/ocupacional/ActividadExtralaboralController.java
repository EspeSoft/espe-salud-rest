package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.ActividadExtralaboralDTO;
import com.espe.salud.service.ocupacional.ActividadExtralaboralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.*;

@RestController
@Tag(description = "Gestiona los actividads extralaborales", name = "Actividades Extralaborales")
@RequestMapping(value = URI_API_V1_ACT_EXT)
public class ActividadExtralaboralController {
    private final ActividadExtralaboralService serviceActividad;

    @Autowired
    public ActividadExtralaboralController(
            @Qualifier("actividadExtraLaboralServiceImpl") ActividadExtralaboralService serviceActividad
    ) {
        this.serviceActividad = serviceActividad;
    }

    @Operation(summary = "Retorna el listado de todos las actividades")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ActividadExtralaboralDTO>> getAll() {
        return new ResponseEntity<>( serviceActividad.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna una actividad por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActividadExtralaboralDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(serviceActividad.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita una actividad por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActividadExtralaboralDTO> update(@RequestBody ActividadExtralaboralDTO actividadDTO, @RequestParam Long codigo) {
        Optional<ActividadExtralaboralDTO> newActividadExtralaboralDTOoptional = serviceActividad.findByCodigo(codigo);
        ActividadExtralaboralDTO newActividadExtralaboralDTO = newActividadExtralaboralDTOoptional.get();
        newActividadExtralaboralDTO.setActividad(actividadDTO.getActividad());
        newActividadExtralaboralDTO.setEmpresa(actividadDTO.getEmpresa());
        newActividadExtralaboralDTO.setMeses(actividadDTO.getMeses());
        newActividadExtralaboralDTO.setObservacion(actividadDTO.getObservacion());
        newActividadExtralaboralDTO.setPuestoTrabajo(actividadDTO.getPuestoTrabajo());
        newActividadExtralaboralDTO.setUsabanSeguridad(actividadDTO.getUsabanSeguridad());
        newActividadExtralaboralDTO.setVigilanciaSalud(actividadDTO.getVigilanciaSalud());
        return new ResponseEntity<>(serviceActividad.update(newActividadExtralaboralDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda una nueva actividad")
    @PostMapping("/")
    public ResponseEntity<ActividadExtralaboralDTO> save(@RequestBody ActividadExtralaboralDTO actividad){
        return new ResponseEntity<>(serviceActividad.save(actividad), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una actividad por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        serviceActividad.delete(codigo);
    }
}
