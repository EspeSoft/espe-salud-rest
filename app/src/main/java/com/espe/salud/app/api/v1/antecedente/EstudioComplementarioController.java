package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.EstudioComplementarioDTO;
import com.espe.salud.service.antecedente.EstudioComplementarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_EST_COM;

@RestController
@RequestMapping(value = {URI_API_V1_EST_COM})
@Tag(description = "Gestiona el catálogo de estudios complementarios", name = "Estudios complentarios")
public class EstudioComplementarioController {

    private final EstudioComplementarioService service;

    @Autowired
    public EstudioComplementarioController(EstudioComplementarioService estudioComplementarioService) {
        this.service = estudioComplementarioService;
    }

    @Operation(summary = "Retorna el listado de todos los estudios complementarios de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EstudioComplementarioDTO>> findByPaciente(
            @Parameter(description = "El ID de un paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>( service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo estudio complementario")
    public ResponseEntity<EstudioComplementarioDTO> save(@RequestBody EstudioComplementarioDTO dto){
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un estudio complementario por su ID")
    public ResponseEntity<Boolean> deleteUser(
            @Parameter(required = true, description = "El ID del estudio complementario", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un estudio complementario")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<EstudioComplementarioDTO> update(@Valid @RequestBody EstudioComplementarioDTO dto,
            @Parameter(description = "El ID del estudio complementario", required = true, example = "1")
            @PathVariable("id") Long id) {
        Optional<EstudioComplementarioDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            EstudioComplementarioDTO nuevo = optional.get();
            nuevo.setDescripcionEstudio(dto.getDescripcionEstudio());
            nuevo.setFechaEstudio(dto.getFechaEstudio());
            nuevo.setNombreEstudio(dto.getNombreEstudio());
            return new ResponseEntity<>( service.update(nuevo), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un estudio complementario por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<EstudioComplementarioDTO> retrieve(
            @Parameter(description = "El ID del estudio complementario", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(estudio -> new ResponseEntity<>(estudio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
