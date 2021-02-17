package com.espe.salud.app.api.v1.catalogo;

import static com.espe.salud.app.common.Constants.URI_API_V1_SUB;

import java.util.List;

import com.espe.salud.dto.catalogo.SubdivisionDTO;

import com.espe.salud.service.catalogo.SubdivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = {URI_API_V1_SUB})
@Tag(description = "Gestiona el catálogo de Subdivision", name = "Subdivisiones")
public class SubdivisionController {

    private final SubdivisionService subdivisionService;

    @Autowired
    public SubdivisionController(SubdivisionService subdivisionService) {
        this.subdivisionService = subdivisionService;
    }

    @Operation(summary = "Retorna el listado de todas las subdivisiones en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SubdivisionDTO>> getAll() {
        return new ResponseEntity<>( subdivisionService.findAll(), HttpStatus.OK);
    }

}
