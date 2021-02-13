package com.espe.salud.app.api.v1.odontologia;

import com.espe.salud.dto.odontologia.EnfermedadProblemaActualDTO;
import com.espe.salud.service.odontologia.EnfermedadProblemaActualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ENF_PRO_ACT;

@RestController
@Tag(description = "Gestiona las enfermedades o problemas de un paciente", name = "Enfermedades y problemas actuales odontología")
@RequestMapping(value = {URI_API_V1_ENF_PRO_ACT})
public class EnfermedadProblemaActualController {

    private final EnfermedadProblemaActualService enfermedadProblemaActualService;

    @Autowired
    public EnfermedadProblemaActualController(EnfermedadProblemaActualService enfermedadProblemaActualService) {
        this.enfermedadProblemaActualService = enfermedadProblemaActualService;
    }

    @PostMapping("")
    @Operation(summary = "Guarda y retorna una nueva enfermedad o problema actual")
    public ResponseEntity<EnfermedadProblemaActualDTO> save(@RequestBody EnfermedadProblemaActualDTO enfermedadProblemaActualDTO){
        return new ResponseEntity<>(enfermedadProblemaActualService.save(enfermedadProblemaActualDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/historiaClinica", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Retorna una lista de enfermedades y/o problemas de un paciente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<List<EnfermedadProblemaActualDTO>> getByHistoriaClinica(
            @Parameter(required = true, description = "El ID de la historia clinica", example = "1")
            @RequestParam Long historiaClinica) {
        return new ResponseEntity<>(enfermedadProblemaActualService.findByHistoriaClinica(historiaClinica), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una enfermedad o problema actual por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<EnfermedadProblemaActualDTO> retrieve(
            @Parameter(description = "El ID de la enfermedad o problema actual", required = true, example = "1")
            @PathVariable("id") Long id) {
        return enfermedadProblemaActualService.findById(id)
                .map(enfermedadProblemaActualDTO -> new ResponseEntity<>(enfermedadProblemaActualDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Elimina una historia clínica por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        enfermedadProblemaActualService.delete(codigo);
    }

    @Operation(summary = "Actualiza una historia clínica por su código")
    @PutMapping(value = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EnfermedadProblemaActualDTO> update(
            @RequestBody EnfermedadProblemaActualDTO dto,
            @PathVariable Long codigo){
        Optional<EnfermedadProblemaActualDTO> enfermedadProblemaActualDTOOptional =  enfermedadProblemaActualService.findById(codigo);
        if(enfermedadProblemaActualDTOOptional.isPresent()) {
            EnfermedadProblemaActualDTO enfermedadProblemaActualDTO = enfermedadProblemaActualDTOOptional.get();
            enfermedadProblemaActualDTO.setCodigoCie(dto.getCodigoCie());
            enfermedadProblemaActualDTO.setDescripcion(dto.getDescripcion());
            return new ResponseEntity<>(enfermedadProblemaActualService.update(enfermedadProblemaActualDTO), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
