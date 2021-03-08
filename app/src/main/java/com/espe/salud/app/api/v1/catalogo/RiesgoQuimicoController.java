package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoQuimico;
import com.espe.salud.dto.catalogo.RiesgoQuimicoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_RIE_QUI;

@RestController
@RequestMapping(value = {URI_API_V1_RIE_QUI})
@Tag(description = "Consulta el cátalogo de riesgos químicos", name = "Riegos quimicos")
public class RiesgoQuimicoController {
    private final GenericCRUDService<RiesgoQuimico, RiesgoQuimicoDTO> riesgoQuimicoService;

    @Autowired
    public RiesgoQuimicoController(
            @Qualifier("riesgoQuimicoServiceImpl") GenericCRUDService<RiesgoQuimico, RiesgoQuimicoDTO> riesgoQuimicoService) {
        this.riesgoQuimicoService = riesgoQuimicoService;
    }

    @Operation(summary = "Retorna el listado de todos los riesgo químicos en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RiesgoQuimicoDTO>> getAll() {
        return new ResponseEntity<>(riesgoQuimicoService.findAllOrderByNameASC(), HttpStatus.OK);
    }
}
