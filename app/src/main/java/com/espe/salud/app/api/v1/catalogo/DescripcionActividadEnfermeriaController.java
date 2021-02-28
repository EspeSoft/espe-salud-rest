package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.DescripcionActividadEnfermeria;
import com.espe.salud.dto.catalogo.DescripcionActividadEnfermeriaDTO;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;
import com.espe.salud.service.catalogo.DescripcionActividadEnfermeriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_DES_ACT_ENF;

@RestController
@RequestMapping(value = {URI_API_V1_DES_ACT_ENF})
@Tag(description = "Gestiona el catálogo de descripciones de actividades de enfermería", name = "Descripcion Actividades Endfermeria")
public class DescripcionActividadEnfermeriaController {

    private final DescripcionActividadEnfermeriaService service;


    @Autowired
    public DescripcionActividadEnfermeriaController(DescripcionActividadEnfermeriaService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos las descripciones de actividades de enfermeria")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DescripcionActividadEnfermeriaDTO>> getAll() {
        return new ResponseEntity<>(service.findAllOrderByNombreASC(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna las descripciones de un tipo de actividad de enfermeria")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/tipoActividad", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DescripcionActividadEnfermeriaDTO>> getByUsuario(
            @Parameter(required = true, description = "El ID del tipo de actividad de enfermeria", example = "1")
            @RequestParam Long idTipoActividad) {
        return new ResponseEntity<>( service.findByDescripcion(idTipoActividad), HttpStatus.OK);
    }
}
