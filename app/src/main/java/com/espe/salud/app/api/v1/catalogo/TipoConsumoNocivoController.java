package com.espe.salud.app.api.v1.catalogo;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_CON_NOC;

import java.util.List;

import com.espe.salud.dto.catalogo.TipoConsumoNocivoDTO;

import com.espe.salud.service.catalogo.TipoConsumoNocivoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;


@RestController
@RequestMapping(value = {URI_API_V1_TIP_CON_NOC})
@Tag(description = "Gestiona el catálogo de tipos de consumo nocivos", name = "Tipos de consumo nocivo")
public class TipoConsumoNocivoController {

    private final TipoConsumoNocivoService tipoConsumoNocivoService;

    @Autowired
    public TipoConsumoNocivoController(TipoConsumoNocivoService tipoConsumoNocivoService) {
        this.tipoConsumoNocivoService = tipoConsumoNocivoService;
    }

    @Operation(summary = "Retorna el listado de todos los consumos nocivos por orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoConsumoNocivoDTO>> getAll() {
        return new ResponseEntity<>(tipoConsumoNocivoService.findAllOrderByNombreASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un consumo nocivo por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<TipoConsumoNocivoDTO> retrieve(
            @Parameter(description = "El ID del consumo nocivo", required = true, example = "1")
            @PathVariable("id") Long id) {
        return tipoConsumoNocivoService.findById(id)
                .map(consumoNocivoDTO -> new ResponseEntity<>(consumoNocivoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nuevo consumo nocivo")
    public ResponseEntity<TipoConsumoNocivoDTO> save(@Valid @RequestBody TipoConsumoNocivoDTO TIpoConsumoNocivoDTO) {
        return new ResponseEntity<>(tipoConsumoNocivoService.save(TIpoConsumoNocivoDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna la lista de tipos de consumos nocivos que inicien por el nombre")
    @GetMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoConsumoNocivoDTO>> findByName(
            @Parameter(description = "Nombre del consumo nocivo", required = true, example = "Alcohol")
            @RequestParam String nombre
    ) {
        return new ResponseEntity<>(tipoConsumoNocivoService.findByNombreStartingWith(nombre), HttpStatus.OK);
    }
}