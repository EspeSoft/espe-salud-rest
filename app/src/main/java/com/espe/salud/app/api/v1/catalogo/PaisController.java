package com.espe.salud.app.api.v1.catalogo;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAI;

import java.util.List;

import com.espe.salud.domain.entities.catalogo.Pais;
import com.espe.salud.dto.catalogo.PaisDTO;
import com.espe.salud.service.GenericCRUDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = {URI_API_V1_PAI})
@Tag(name = "Gestiona el catálogo de país")
public class PaisController {

    private final GenericCRUDService<Pais, PaisDTO> paisService;

    @Autowired
    public PaisController(
            @Qualifier("PaisServiceImpl") GenericCRUDService<Pais, PaisDTO> paisService) {
        this.paisService = paisService;
    }


    @Operation(summary = "Retorna el listado de todos los paises")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PaisDTO>> getAll() {
        PaisDTO PaisDTO = new PaisDTO();
        return new ResponseEntity<>( paisService.findAll(PaisDTO), HttpStatus.OK);
    }

}