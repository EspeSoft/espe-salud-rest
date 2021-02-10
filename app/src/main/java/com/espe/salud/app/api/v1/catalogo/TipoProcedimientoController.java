package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoProcedimiento;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_TIPO_PROC;

@RestController
@RequestMapping(value = {URI_API_V1_TIPO_PROC})
@Tag(name = "Gestiona el catalogo de tipos de procedimiento")
public class TipoProcedimientoController {
    private final GenericCRUDService<TipoProcedimiento, TipoProcedimientoDTO> tipoProcedimientoService;

    @Autowired
    public TipoProcedimientoController(
            @Qualifier("TipoProcedimientoServiceImpl")GenericCRUDService<TipoProcedimiento, TipoProcedimientoDTO> tipoProcedimientoService) {
        this.tipoProcedimientoService = tipoProcedimientoService;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de procedimiento")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoProcedimientoDTO>> getAll() {
        TipoProcedimientoDTO tipoProcedimientoDTO = new TipoProcedimientoDTO();
        return new ResponseEntity<>( tipoProcedimientoService.findAll(tipoProcedimientoDTO), HttpStatus.OK);
    }

}
