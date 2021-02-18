package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedad;
import com.espe.salud.dto.catalogo.TipoEnfermedadDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_ENF;

@RestController
@RequestMapping(value = {URI_API_V1_TIP_ENF})
@Tag(description = "Gestiona el catálogo de tipos de enfermedades", name = "Tipos de enfermedad")
public class TipoEnfermedadController {

    private final GenericCRUDService<TipoEnfermedad, TipoEnfermedadDTO> tipoEnfermedadService;

    @Autowired
    public TipoEnfermedadController(
            @Qualifier("tipoEnfermedadServiceImpl") GenericCRUDService<TipoEnfermedad, TipoEnfermedadDTO> tipoEnfermedadService) {
        this.tipoEnfermedadService = tipoEnfermedadService;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de enfermedades")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoEnfermedadDTO>> getAll() {
        TipoEnfermedadDTO tipoEnfermedadDTO = new TipoEnfermedadDTO();
        return new ResponseEntity<>( tipoEnfermedadService.findAll(tipoEnfermedadDTO), HttpStatus.OK);
    }
}
