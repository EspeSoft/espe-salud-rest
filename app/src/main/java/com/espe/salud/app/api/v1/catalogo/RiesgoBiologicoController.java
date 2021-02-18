package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoBiologico;
import com.espe.salud.dto.catalogo.RiesgoBiologicoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_RIE_BIO;

@RestController
@RequestMapping(value = {URI_API_V1_RIE_BIO})
@Tag(description = "Consulta el cátalogo de riesgos biológicos", name = "Riesgos biológicos")
public class RiesgoBiologicoController {
    private final GenericCRUDService<RiesgoBiologico, RiesgoBiologicoDTO> riesgoBiologicoService;

    @Autowired
    public RiesgoBiologicoController(
            @Qualifier("riesgoBiologicoServiceImpl") GenericCRUDService<RiesgoBiologico, RiesgoBiologicoDTO> riesgoBiologicoService) {
        this.riesgoBiologicoService = riesgoBiologicoService;
    }

    @Operation(summary = "Retorna el listado de todos los riesgo biológicos en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RiesgoBiologicoDTO>> getAll() {
        return new ResponseEntity<>( riesgoBiologicoService.findAllOrderByNameASC(), HttpStatus.OK);
    }
}

