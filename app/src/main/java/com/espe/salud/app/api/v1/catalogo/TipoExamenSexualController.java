package com.espe.salud.app.api.v1.catalogo;


import com.espe.salud.dto.catalogo.TipoExamenSexualDTO;
import com.espe.salud.service.catalogo.TipoExamenSexualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_EXA_SEX;

@RestController
@RequestMapping(value = {URI_API_V1_TIP_EXA_SEX})
@Tag(description = "Gestiona el catálogo de tipos de examenes sexuales", name = "Tipos de examenes sexuales")
public class TipoExamenSexualController {

    private final TipoExamenSexualService service;

    @Autowired
    public TipoExamenSexualController(TipoExamenSexualService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de los tipos de examenes sexuales de MUJERES")
    @GetMapping(value = "/findAllMujeres", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoExamenSexualDTO>> findAllMujeres() {
        return new ResponseEntity<>(service.findAllMujeres(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna el listado los tipos de examenes sexuales de HOMBRES")
    @GetMapping(value = "/findAllHombres", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoExamenSexualDTO>> findAllHombres() {
        return new ResponseEntity<>(service.findAllHombres(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna el listado de todos los tipos de examenes sexuales en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoExamenSexualDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un tipo de examen sexual por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<TipoExamenSexualDTO> retrieve(
            @Parameter(description = "El ID de un tipo de examen sexual", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un tipo de examen sexual")
    public ResponseEntity<TipoExamenSexualDTO> save(@RequestBody TipoExamenSexualDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }
}
