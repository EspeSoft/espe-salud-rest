package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.OrganoSistema;
import com.espe.salud.dto.catalogo.OrganoSistemaDTO;
import com.espe.salud.service.GenericCRUDService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ORG_SIST;

@RestController
@RequestMapping(value = {URI_API_V1_ORG_SIST})
@Tag(description = "Gestiona el catalogo de regiones", name = "Órganos y sistemas")
public class OrganoSistemaController {

    private final GenericCRUDService<OrganoSistema, OrganoSistemaDTO> organoSistemaService;

    @Autowired
    public OrganoSistemaController(
            @Qualifier("organoSistemaServiceImpl")GenericCRUDService<OrganoSistema, OrganoSistemaDTO> organoSistemaService) {
        this.organoSistemaService = organoSistemaService;
    }

    @Operation(summary = "Retorna el listado de todos los organos Sistema")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<OrganoSistemaDTO>> getAll() {
        OrganoSistemaDTO organoSistemaDTO = new OrganoSistemaDTO();
        return new ResponseEntity<>( organoSistemaService.findAll(organoSistemaDTO), HttpStatus.OK);
    }

}
