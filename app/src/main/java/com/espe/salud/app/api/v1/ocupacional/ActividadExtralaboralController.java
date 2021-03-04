package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.ActividadExtralaboralDTO;
import com.espe.salud.dto.ocupacional.AntecedenteLaboralDTO;
import com.espe.salud.service.ocupacional.ActividadExtralaboralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Retorna las actividades extralaborales de una antedente laboral")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<List<ActividadExtralaboralDTO>> retrieveByAntecedenteLaboral(
            @Parameter(description = "El ID de un Antecedente Laboral", required = true, example = "1")
            @RequestParam Long idAntecedente
    ) {
        return new ResponseEntity<>(serviceActividad.findByAntecedenteLaboral(idAntecedente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna una actividad por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<List<ActividadExtralaboralDTO>> retrieve(
            @Parameter(description = "El ID de la actividad extralaboral", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(serviceActividad.findByCodigo(id), HttpStatus.OK);
    }

    @Operation(summary = "Guarda una nueva actividad")
    @PostMapping("")
    public ResponseEntity<ActividadExtralaboralDTO> save(@RequestBody ActividadExtralaboralDTO actividad) {
        return new ResponseEntity<>(serviceActividad.save(actividad), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una actividad por su id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        serviceActividad.delete(id);
    }

    @Operation(summary = "Edita una actividad extralaboral por su id")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ActividadExtralaboralDTO> update(
            @RequestBody ActividadExtralaboralDTO actividadDTO,
            @Parameter(description = "El ID de la actividad extralaboral", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        Optional<ActividadExtralaboralDTO> newActividadExtralaboralDTOoptional = serviceActividad.findByCodigo(id);
        ActividadExtralaboralDTO newActividadExtralaboralDTO = newActividadExtralaboralDTOoptional.get();
        newActividadExtralaboralDTO.setActividad(actividadDTO.getActividad());
        newActividadExtralaboralDTO.setEmpresa(actividadDTO.getEmpresa());
        newActividadExtralaboralDTO.setMeses(actividadDTO.getMeses());
        newActividadExtralaboralDTO.setObservacion(actividadDTO.getObservacion());
        newActividadExtralaboralDTO.setPuestoTrabajo(actividadDTO.getPuestoTrabajo());
        newActividadExtralaboralDTO.setUsabanSeguridad(actividadDTO.getUsabanSeguridad());
        newActividadExtralaboralDTO.setVigilanciaSalud(actividadDTO.getVigilanciaSalud());
        return new ResponseEntity<>(serviceActividad.update(newActividadExtralaboralDTO), HttpStatus.CREATED);
    }

}
