package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoMecanico;
import com.espe.salud.dto.catalogo.RiesgoMecanicoDTO;
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
import static com.espe.salud.app.common.Constants.URI_API_V1_RIE_MEC;

@RestController
@RequestMapping(value = {URI_API_V1_RIE_MEC})
@Tag(name = "Consulta el cátalogo de riesgos mecánicos")
public class RiesgoMecanicoController {
    private final GenericCRUDService<RiesgoMecanico, RiesgoMecanicoDTO> riesgoMecanicoService;

    @Autowired
    public RiesgoMecanicoController(
            @Qualifier("riesgoMecanicoServiceImpl") GenericCRUDService<RiesgoMecanico, RiesgoMecanicoDTO> riesgoMecanicoService) {
        this.riesgoMecanicoService = riesgoMecanicoService;
    }

    @Operation(summary = "Retorna el listado de todos los riesgo mecánicos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RiesgoMecanicoDTO>> getAll() {
        RiesgoMecanicoDTO riesgoMecanicoDTO = new RiesgoMecanicoDTO();
        return new ResponseEntity<>( riesgoMecanicoService.findAll(riesgoMecanicoDTO), HttpStatus.OK);
    }
}

