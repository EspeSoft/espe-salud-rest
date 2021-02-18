package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.ProblemaSocial;
import com.espe.salud.dto.catalogo.ProblemaSocialDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_PRO_SOC;

@RestController
@RequestMapping(value = {URI_API_V1_PRO_SOC})
@Tag(description = "Gestiona el catálogo de problemas sociales", name = "Problemas sociales")
public class ProblemaSocialController {

    private final GenericCRUDService<ProblemaSocial, ProblemaSocialDTO> service;

    @Autowired
    public ProblemaSocialController(
            @Qualifier("problemaSocialServiceImpl") GenericCRUDService<ProblemaSocial, ProblemaSocialDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los problemas sociales en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProblemaSocialDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un problema social por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ProblemaSocialDTO> retrieve(
            @Parameter(description = "El ID del problema social", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo problema social")
    public ResponseEntity<ProblemaSocialDTO> save(@RequestBody ProblemaSocialDTO problemaSocialDTO){
        return new ResponseEntity<>(service.saveOrUpdate(problemaSocialDTO), HttpStatus.CREATED);
    }
}
