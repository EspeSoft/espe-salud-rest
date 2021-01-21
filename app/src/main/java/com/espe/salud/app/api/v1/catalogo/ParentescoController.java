package com.espe.salud.app.api.v1.catalogo;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAR;

import com.espe.salud.domain.Parentesco;
import com.espe.salud.dto.ParentescoDTO;
import com.salud.espe.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {URI_API_V1_PAR})
@Tag(name = "Gestiona el cátalodo de parentescos")
public class ParentescoController {

    @Autowired
    @Qualifier("parentescoServiceImpl")
    private GenericCRUDService<Parentesco, ParentescoDTO> parentescoService;


    @Operation(summary = "Retorna el listado de todos los parentescos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ParentescoDTO>> getAll() {
        ParentescoDTO parentescoDTO = new ParentescoDTO();
        return new ResponseEntity<>( parentescoService.findAll(parentescoDTO), HttpStatus.OK);
    }
}
