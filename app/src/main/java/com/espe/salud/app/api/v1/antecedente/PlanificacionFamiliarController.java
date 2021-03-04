package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;
import com.espe.salud.service.antecedente.PlanificacionFamiliarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_PLAFAM;

@RestController
@Tag(name = "Gestiona Planificación Familiar")
@RequestMapping(value = {URI_API_V1_PLAFAM})
public class PlanificacionFamiliarController {

    private final PlanificacionFamiliarService service;

    @Autowired
    public PlanificacionFamiliarController(PlanificacionFamiliarService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos las Planificaciones Familiares")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PlanificacionFamiliarDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna una planificación familiar por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PlanificacionFamiliarDTO> getById(@Parameter(description = "El codigo dela planificación familiar", required = true, example = "1") @PathVariable("codigo") Long id) {
        return new ResponseEntity(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edita una planificación familiar por su codigo")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PlanificacionFamiliarDTO> update(@RequestBody PlanificacionFamiliarDTO dto, @RequestParam Long codigo) {
        Optional<PlanificacionFamiliarDTO> newPlanificacionFamiliarDTOoptional = service.findById(codigo);
        PlanificacionFamiliarDTO newPlanificacionFamiliarDTO = newPlanificacionFamiliarDTOoptional.get();
        newPlanificacionFamiliarDTO.setFecha(dto.getFecha());
        newPlanificacionFamiliarDTO.setVidaSexualActiva(dto.getVidaSexualActiva());
        newPlanificacionFamiliarDTO.setMetodoPlanificacion(dto.getMetodoPlanificacion());
        newPlanificacionFamiliarDTO.setEdadInicioPlanificacionFamiliar(dto.getEdadInicioPlanificacionFamiliar());
        newPlanificacionFamiliarDTO.setFrecuenciaPlanificacionFamiliar(dto.getFrecuenciaPlanificacionFamiliar());
        newPlanificacionFamiliarDTO.setTipoPlanificacionFamiliar(dto.getTipoPlanificacionFamiliar());
        newPlanificacionFamiliarDTO.setHijosVivos(dto.getHijosVivos());
        newPlanificacionFamiliarDTO.setHijosMuertos(dto.getHijosMuertos());
        newPlanificacionFamiliarDTO.setObservacion(dto.getObservacion());
        newPlanificacionFamiliarDTO.setAntecedentePersonal(dto.getAntecedentePersonal());
        return new ResponseEntity<>(service.update(newPlanificacionFamiliarDTO), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar una nueva planificación familiar")
    @PostMapping("/")
    public ResponseEntity<PlanificacionFamiliarDTO> save(@RequestBody PlanificacionFamiliarDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una planificación familiar por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        service.deleteById(codigo);
    }
}


