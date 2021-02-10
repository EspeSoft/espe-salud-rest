package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoEnfermedad;
import com.espe.salud.dto.catalogo.GrupoEnfermedadDTO;
import com.espe.salud.dto.catalogo.TipoProcedimientoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_GRUPO_ENFERMEDAD;

@RestController
@RequestMapping(value = {URI_API_V1_GRUPO_ENFERMEDAD})
@Tag(name = "Gestiona el catalogo de grupos de enfermedades")
public class GrupoEnfermedadController {
    private final GenericCRUDService<GrupoEnfermedad, GrupoEnfermedadDTO> grupoEnfermedadService;

    @Autowired
    public GrupoEnfermedadController(
            @Qualifier("GrupoEnfermedadServiceImpl")GenericCRUDService<GrupoEnfermedad, GrupoEnfermedadDTO> grupoEnfermedadService) {
        this.grupoEnfermedadService = grupoEnfermedadService;
    }

    @Operation(summary = "Retorna el listado de todos los grupos de enfermedades")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<GrupoEnfermedadDTO>> getAll() {
        GrupoEnfermedadDTO grupoEnfermedadDTO = new GrupoEnfermedadDTO();
        return new ResponseEntity<>( grupoEnfermedadService.findAll(grupoEnfermedadDTO), HttpStatus.OK);
    }
}
