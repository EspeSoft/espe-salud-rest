package com.espe.salud.app.api.v1.usuario;

import com.espe.salud.dto.usuario.AreaSaludDTO;
import com.espe.salud.service.usuario.AreaSaludService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_AREAS_SALUD;

@RestController
@Tag(description = "Gestiona las áreas de salud", name = "Áreas de Salud")
@RequestMapping(value = {URI_API_V1_AREAS_SALUD})
public class AreaSaludController {
    private final AreaSaludService service;

    @Autowired
    public AreaSaludController(AreaSaludService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna la lista de todos las áreas de salud")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AreaSaludDTO>> getAll() {
        return new ResponseEntity<>( service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un área de salud por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<AreaSaludDTO> retrieve(
            @Parameter(description = "El ID del usuario", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(areaSalud -> new ResponseEntity<>(areaSalud, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
