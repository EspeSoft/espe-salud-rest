package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.OrientacionSexual;
import com.espe.salud.dto.catalogo.OrientacionSexualDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ORIENTACIONES_SEXUALES;

@RestController
@RequestMapping(value = {URI_API_V1_ORIENTACIONES_SEXUALES})
@Tag(description = "Gestiona el catálogo de orientaciones sexuales", name = "Orientaciones sexuales")
public class OrientacionSexualController {

    private final GenericCRUDService<OrientacionSexual, OrientacionSexualDTO> service;

    @Autowired
    public OrientacionSexualController(
            @Qualifier("orientacionSexualServiceImpl") GenericCRUDService<OrientacionSexual, OrientacionSexualDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de las orientaciones sexuales en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<OrientacionSexualDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una orientación sexual por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<OrientacionSexualDTO> retrieve(
            @Parameter(description = "El ID de la orientación sexual", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nueva orientación sexual")
    public ResponseEntity<OrientacionSexualDTO> save(@RequestBody OrientacionSexualDTO orientacionSexualDTO){
        return new ResponseEntity<>(service.saveOrUpdate(orientacionSexualDTO), HttpStatus.CREATED);
    }

}
