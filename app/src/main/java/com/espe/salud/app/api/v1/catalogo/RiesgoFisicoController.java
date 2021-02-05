package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoFisico;
import com.espe.salud.dto.catalogo.RiesgoFisicoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_RIE_FIS;

@RestController
@RequestMapping(value = {URI_API_V1_RIE_FIS})
@Tag(name = "Consulta el cátalogo de riesgos físicos")
public class RiesgoFisicoController {
    private final GenericCRUDService<RiesgoFisico, RiesgoFisicoDTO> riesgoFisicoService;

    @Autowired
    public RiesgoFisicoController(
            @Qualifier("riesgoFisicoServiceImpl") GenericCRUDService<RiesgoFisico, RiesgoFisicoDTO> riesgoFisicoService) {
        this.riesgoFisicoService = riesgoFisicoService;
    }

    @Operation(summary = "Retorna el listado de todos los riesgo físicos en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RiesgoFisicoDTO>> getAll() {
        return new ResponseEntity<>( riesgoFisicoService.findAllOrderByNameASC(), HttpStatus.OK);
    }
}

