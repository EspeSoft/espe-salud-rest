package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDiscapacidad;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.dto.catalogo.TipoDiscapacidadDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_DIS;

@RestController
@RequestMapping(value = {URI_API_V1_TIP_DIS})
@Tag(name = "Gestiona el cátalodo de tipos de discapacidad")
public class TipoDiscapacidadController {
    private final GenericCRUDService<TipoDiscapacidad, TipoDiscapacidadDTO> service;

    @Autowired
    public TipoDiscapacidadController(
            @Qualifier("tipoDiscapacidadServiceImpl") GenericCRUDService<TipoDiscapacidad, TipoDiscapacidadDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de discapacidad en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoDiscapacidadDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo tipo de discapaciad")
    public ResponseEntity<TipoDiscapacidadDTO> save(@RequestBody TipoDiscapacidadDTO tipoDiscapacidadDTO){
        return new ResponseEntity<>(service.saveOrUpdate(tipoDiscapacidadDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna un tipo de discapacidad por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TipoDiscapacidadDTO> findById(
            @Parameter(description = "El ID del tipo de discapacidad", required = true, example = "1")
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

}
