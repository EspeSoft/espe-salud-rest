package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.AreaDTO;
import com.espe.salud.service.catalogo.AreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_AREA;

@RestController
@RequestMapping(value = {URI_API_V1_AREA})
@Tag(description = "Gestiona el catalogo de areas", name = "Áreas")
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(
            AreaService areaService) {
        this.areaService = areaService;
    }

    @Operation(summary = "Retorna el listado de todas las areas")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AreaDTO>> getAll() {
        return new ResponseEntity<>( areaService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna el listado de todas las areas de una región")
    @GetMapping(value = "/search/region", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AreaDTO>> findByRegion(
            @Parameter(description = "El ID de la region", required = true, example = "1")
            @RequestParam Long idRegion
    ) {
        return new ResponseEntity<>( areaService.findAllByRegion(idRegion), HttpStatus.OK);
    }
}
