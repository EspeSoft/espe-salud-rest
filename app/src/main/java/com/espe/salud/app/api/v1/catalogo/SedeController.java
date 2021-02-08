package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.Sede;
import com.espe.salud.dto.catalogo.SedeDTO;
import com.espe.salud.dto.enfermeria.NotaEnfermeriaDTO;
import com.espe.salud.service.catalogo.SedeService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_SED;

@RestController
@RequestMapping(value = {URI_API_V1_SED})
@Tag(name = "Gestiona las sedes")
public class SedeController {

    private final SedeService sedeService;

    @Autowired
    public SedeController(SedeService sedeService) {
        this.sedeService = sedeService;
    }
    @Operation(summary = "Retorna el listado de las sedes")
    @GetMapping(value = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SedeDTO>> getAll(){

        return new ResponseEntity<>(sedeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    @Operation(summary = "Retorna una sede por su codigo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<SedeDTO> getById(
            @Parameter(description = "El codigo de la sede", required = true, example = "1")
            @PathVariable("codigo") Long id) {
        return sedeService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}