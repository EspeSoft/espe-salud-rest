package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoErgonomico;
import com.espe.salud.dto.catalogo.RiesgoErgonomicoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_RIE_ERG;
import static com.espe.salud.app.common.Constants.URI_API_V1_RIE_FIS;

@RestController
@RequestMapping(value = {URI_API_V1_RIE_ERG})
@Tag(name = "Consulta el cátalogo de riesgos ergonómicos")
public class RiesgoErgonomicoController {
    private final GenericCRUDService<RiesgoErgonomico, RiesgoErgonomicoDTO> riesgoErgonomicoService;

    @Autowired
    public RiesgoErgonomicoController(
            @Qualifier("riesgoErgonomicoServiceImpl") GenericCRUDService<RiesgoErgonomico, RiesgoErgonomicoDTO> riesgoErgonomicoService) {
        this.riesgoErgonomicoService = riesgoErgonomicoService;
    }

    @Operation(summary = "Retorna el listado de todos los riesgo ergonómicos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RiesgoErgonomicoDTO>> getAll() {
        RiesgoErgonomicoDTO riesgoErgonomicoDTO = new RiesgoErgonomicoDTO();
        return new ResponseEntity<>( riesgoErgonomicoService.findAll(riesgoErgonomicoDTO), HttpStatus.OK);
    }
}

