package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.CodigoCIE10;
import com.espe.salud.dto.catalogo.CodigoCIE10DTO;
import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_CODIGO_CIE10;

@RestController
@RequestMapping(value = {URI_API_V1_CODIGO_CIE10})
@Tag(name = "Gestiona el catalogo de codigos")
public class CodigoCIE10Controller {
    private final GenericCRUDService<CodigoCIE10, CodigoCIE10DTO> codigoCIE10Service;

    public CodigoCIE10Controller(
            @Qualifier("CodigoCIE10ServiceImpl")GenericCRUDService<CodigoCIE10, CodigoCIE10DTO> codigoCIE10Service) {
        this.codigoCIE10Service = codigoCIE10Service;
    }

    @Operation(summary = "Retorna el listado de todas los tipos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CodigoCIE10DTO>> getAll() {
        CodigoCIE10DTO codigoCIE10DTO = new CodigoCIE10DTO();
        return new ResponseEntity<>( codigoCIE10Service.findAll(codigoCIE10DTO), HttpStatus.OK);
    }

}
