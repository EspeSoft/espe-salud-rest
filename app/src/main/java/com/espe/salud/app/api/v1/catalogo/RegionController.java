package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.dto.catalogo.RegionDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_REG;

@RestController
@RequestMapping(value = {URI_API_V1_REG})
@Tag(description = "Gestiona el catalogo de regiones", name = "Regiones")
public class RegionController {

    private final GenericCRUDService<Region, RegionDTO> regionService;

    @Autowired
    public RegionController(
            @Qualifier("regionServiceImpl") GenericCRUDService<Region, RegionDTO> regionService) {
        this.regionService = regionService;
    }

    @Operation(summary = "Retorna el listado de todas las regiones")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RegionDTO>> getAll() {
        return new ResponseEntity<>(regionService.findAllOrderByNameASC(), HttpStatus.OK);
    }


}
