package com.espe.salud.app.api.v1.catalogo;

import static com.espe.salud.app.common.Constants.URI_API_V1_CON_NOC;

import java.util.List;

import com.espe.salud.dto.catalogo.ConsumoNocivoDTO;

import com.espe.salud.service.catalogo.ConsumoNocivoService;
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
@RequestMapping(value = {URI_API_V1_CON_NOC})
@Tag(name = "Gestiona el catálogo de consumos nocivos")
public class ConsumoNocivoController {

    private final ConsumoNocivoService consumoNocivoService;

    @Autowired
    public ConsumoNocivoController(ConsumoNocivoService consumoNocivoService) {
        this.consumoNocivoService = consumoNocivoService;
    }

    @Operation(summary = "Retorna el listado de todos los consumos nocivos por orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ConsumoNocivoDTO>> getAll() {
        return new ResponseEntity<>(consumoNocivoService.findAllOrderByNombreASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un consumo nocivo por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ConsumoNocivoDTO> retrieve(
            @Parameter(description = "El ID del consumo nocivo", required = true, example = "1")
            @PathVariable("id") Long id) {
        return consumoNocivoService.findById(id)
                .map(consumoNocivoDTO -> new ResponseEntity<>(consumoNocivoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nuevo consumo nocivo")
    public ResponseEntity<ConsumoNocivoDTO> save(@Valid @RequestBody ConsumoNocivoDTO consumoNocivoDTO){
        return new ResponseEntity<>(consumoNocivoService.save(consumoNocivoDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna la búsqueda de consumos nocivos que inicien por el nombre")
    @GetMapping(value = "/findByName", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ConsumoNocivoDTO>> findByName(
            @Parameter(description = "El ID de la nacionaliad o pueblo", required = true, example = "Alcohol")
            @RequestParam String nombre
    ) {
        return new ResponseEntity<>(consumoNocivoService.findByNombreStartingWith(nombre), HttpStatus.OK);
    }
}