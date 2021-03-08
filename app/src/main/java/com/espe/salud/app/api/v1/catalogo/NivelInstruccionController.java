package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.NivelInstruccion;
import com.espe.salud.dto.catalogo.NivelInstruccionDTO;
import com.espe.salud.dto.catalogo.ParentescoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_NIVEL_INSTRUCCION;

@RestController
@RequestMapping(value = {URI_API_V1_NIVEL_INSTRUCCION})
@Tag(description = "Gestiona el catálogo de niveles de instrucción", name = "Niveles de instrucción")
public class NivelInstruccionController {
    private final GenericCRUDService<NivelInstruccion, NivelInstruccionDTO> service;

    @Autowired
    public NivelInstruccionController(
            @Qualifier("nivelInstruccionServiceImpl") GenericCRUDService<NivelInstruccion, NivelInstruccionDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los niveles de instruccion en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NivelInstruccionDTO>> getAll() {
        return new ResponseEntity<>(service.findAllOrderByNameASC(), HttpStatus.OK);
    }
}
