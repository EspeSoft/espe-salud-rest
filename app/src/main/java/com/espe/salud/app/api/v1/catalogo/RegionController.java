package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.dto.catalogo.RegionDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@Tag(name = "Gestiona el catalogo de regiones")
public class RegionController {

    private final GenericCRUDService<Region, RegionDTO> regionService;

    @Autowired
    public RegionController(
            @Qualifier("RegionServiceImpl") GenericCRUDService<Region, RegionDTO> regionService) {
        this.regionService = regionService;
    }

    @Operation(summary = "Retorna el listado de todos las regiones")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RegionDTO>> getAll() {
        RegionDTO regionDTO = new RegionDTO();
        return new ResponseEntity<>( regionService.findAll(regionDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nueva region")
    public ResponseEntity<RegionDTO> save(@RequestBody RegionDTO regionDTO){
        return new ResponseEntity<>(regionService.saveOrUpdate(regionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una region por su ID")
    public ResponseEntity<Boolean> deleteUser(
            @Parameter(required = true, description = "El ID de la region", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(regionService.delete(id), HttpStatus.OK);
    }

}
