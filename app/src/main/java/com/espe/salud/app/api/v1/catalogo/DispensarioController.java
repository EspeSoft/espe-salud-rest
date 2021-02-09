package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.DispensarioDTO;
import com.espe.salud.dto.catalogo.SedeDTO;
import com.espe.salud.service.catalogo.DispensarioService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_DISP;

@RestController
@RequestMapping(value = {URI_API_V1_DISP})
@Tag(name = "Gestiona los dispensarios")
public class DispensarioController {

    private final DispensarioService dispensarioService;

    @Autowired
    public DispensarioController(DispensarioService dispensarioService) {
        this.dispensarioService = dispensarioService;
    }

    @Operation(summary = "Retorna el listado de dispensarios")
    @GetMapping(value = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DispensarioDTO>> getAll(){

        return new ResponseEntity<>(dispensarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un dispensario por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<DispensarioDTO> getById(
            @Parameter(description = "El ID del dispensario", required = true, example = "1")
            @PathVariable("id") Long id) {
        return dispensarioService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/image/{nombreImagen}")
    @Operation(summary = "Retorna un dispensario por su nombre")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<DispensarioDTO> getByNombreImagen(
            @Parameter(description = "El nombre de la imagen del dispensario", required = true, example = "LATACUNGA")
            @PathVariable("nombreImagen") String nombre) {
        return dispensarioService.findByNombre(nombre)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
