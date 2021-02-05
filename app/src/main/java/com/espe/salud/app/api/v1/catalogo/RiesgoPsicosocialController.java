package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoPsicosocial;
import com.espe.salud.dto.catalogo.RiesgoPsicosocialDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_RIE_PSI;

@RestController
@RequestMapping(value = {URI_API_V1_RIE_PSI})
@Tag(name = "Consulta el cátalogo de riesgos psicosociales")
public class RiesgoPsicosocialController {
    private final GenericCRUDService<RiesgoPsicosocial, RiesgoPsicosocialDTO> riesgoPsicosocialService;

    @Autowired
    public RiesgoPsicosocialController(
            @Qualifier("riesgoPsicosocialServiceImpl") GenericCRUDService<RiesgoPsicosocial, RiesgoPsicosocialDTO> riesgoPsicosocialService) {
        this.riesgoPsicosocialService = riesgoPsicosocialService;
    }

    @Operation(summary = "Retorna el listado de todos los riesgo psicosociales en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RiesgoPsicosocialDTO>> getAll() {
        return new ResponseEntity<>( riesgoPsicosocialService.findAllOrderByNameASC(), HttpStatus.OK);
    }
}

