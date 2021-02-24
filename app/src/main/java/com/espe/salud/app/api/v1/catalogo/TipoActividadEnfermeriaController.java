package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.DescripcionActividadEnfermeriaDTO;
import com.espe.salud.dto.catalogo.TipoActividadEnfermeriaDTO;
import com.espe.salud.service.catalogo.TipoActividadEnfermeriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIP_ACT_ENF;

@RestController
@Tag(description = "Gestiona el cátalodo de los tipos de actividades de enfermería", name = "Tipo Actividad Enfermeria")
@RequestMapping(value = {URI_API_V1_TIP_ACT_ENF})
public class TipoActividadEnfermeriaController {

    private final TipoActividadEnfermeriaService service;

    @Autowired
    public TipoActividadEnfermeriaController(TipoActividadEnfermeriaService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de actividades de enfermería por orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoActividadEnfermeriaDTO>> getAll() {
        return new ResponseEntity<>(service.findAllOrderByNombreASC(), HttpStatus.OK);
    }
}
