package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import com.espe.salud.dto.catalogo.AreaDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ENFERMEDAD_CIE10;

@RestController
@RequestMapping(value = {URI_API_V1_ENFERMEDAD_CIE10})
@Tag(name = "Gestiona el catalogo de enfermedades")
public class EnfermedadCIE10Controller {
    private final GenericCRUDService<EnfermedadCIE10, EnfermedadCIE10DTO> enfermedadCIE10Service;

    public EnfermedadCIE10Controller(
            @Qualifier("EnfermedadCIE10ServiceImpl")GenericCRUDService<EnfermedadCIE10, EnfermedadCIE10DTO> enfermedadCIE10Service) {
        this.enfermedadCIE10Service = enfermedadCIE10Service;
    }

    @Operation(summary = "Retorna el listado de todas las enfermedades")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EnfermedadCIE10DTO>> getAll() {
        EnfermedadCIE10DTO enfermedadCIE10DTO = new EnfermedadCIE10DTO();
        return new ResponseEntity<>( enfermedadCIE10Service.findAll(enfermedadCIE10DTO), HttpStatus.OK);
    }
}
