package com.espe.salud.app.api.v1.usuario;

import com.espe.salud.dto.usuario.UsuarioDTO;
import com.espe.salud.service.usuario.UsuarioService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_USU;

@RestController
@Tag(name = "Gestiona los usuarios del sistema")
@RequestMapping(value = {URI_API_V1_USU})
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.usuarioService = service;
    }

    @Operation(summary = "Retorna la lista de todos los usuarios")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return new ResponseEntity<>( usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un usuario por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<UsuarioDTO> retrieve(
            @Parameter(description = "El ID del usuario", required = true, example = "1")
            @PathVariable("id") Long id) {
        return usuarioService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
