package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.Area;
import com.espe.salud.dto.catalogo.AreaDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_AREA;

@RestController
@RequestMapping(value = {URI_API_V1_AREA})
@Tag(description = "Gestiona el catalogo de areas", name = "Áreas")
public class AreaController {
    private final GenericCRUDService<Area, AreaDTO> areaService;

    @Autowired
    public AreaController(
            @Qualifier("AreaServiceImpl") GenericCRUDService<Area, AreaDTO> areaService) {
        this.areaService = areaService;
    }

    @Operation(summary = "Retorna el listado de todos las areas")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AreaDTO>> getAll() {
        AreaDTO areaDTO = new AreaDTO();
        return new ResponseEntity<>( areaService.findAll(areaDTO), HttpStatus.OK);
    }


}
