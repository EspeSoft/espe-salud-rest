package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteLaboralDTO;
import com.espe.salud.service.ocupacional.AntecedenteLaboralService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_ACC_TRA;
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_LAB;

@RestController
@Tag(description = "Gestiona los antecedentes laborales", name = "Antecedentes Laborales")
@RequestMapping(value = URI_API_V1_ANT_LAB)
public class AntecedenteLaboralController {
    private final AntecedenteLaboralService serviceAntecedente;

    @Autowired
    public AntecedenteLaboralController(
            @Qualifier("antecedenteLaboralServiceImpl") AntecedenteLaboralService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }

    @Operation(summary = "Retorna un antecedente laboral por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<AntecedenteLaboralDTO> retrieve(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(id), HttpStatus.OK);
    }

    @Operation(summary = "Retorna el antecedente laboral de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<AntecedenteLaboralDTO> getByPaciente(
            @Parameter(description = "El ID de un Paciente", required = true, example = "1")
            @RequestParam Long idPaciente
    ) {
        return serviceAntecedente.findByPaciente(idPaciente)
                .map(antecedenteLaboralDTO -> new ResponseEntity<>(antecedenteLaboralDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Guarda un nuevo antecedente laboral")
    @PostMapping("")
    public ResponseEntity<AntecedenteLaboralDTO> save(@RequestBody AntecedenteLaboralDTO antecedente) {
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su id")
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable("id") Long id
    ) {
        serviceAntecedente.delete(id);
    }

    @Operation(summary = "Edita un antecedente por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteLaboralDTO> update(
            @RequestBody AntecedenteLaboralDTO antecedenteDTO,
            @PathVariable("id") Long id) {
        Optional<AntecedenteLaboralDTO> newAntecedenteLaboralDTOoptional = serviceAntecedente.findByCodigo(id);
        AntecedenteLaboralDTO newAntecedenteLaboralDTO = newAntecedenteLaboralDTOoptional.get();
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteLaboralDTO), HttpStatus.CREATED);
    }
}
