package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.UnidadDepartamento;
import com.espe.salud.dto.catalogo.UnidadDepartamentoDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_UNIDEP;

@RestController
@RequestMapping(value = {URI_API_V1_UNIDEP})
@Tag(description = "Gestiona el cátalodo de Unidad Departamento", name = "Unidades y departamentos")
public class UnidadDepartamentoController {
    private final GenericCRUDService<UnidadDepartamento, UnidadDepartamentoDTO> unidadDepartamentoService;

    @Autowired
    public UnidadDepartamentoController(
            @Qualifier("unidadDepartamentoServiceImpl") GenericCRUDService<UnidadDepartamento, UnidadDepartamentoDTO> unidadDepartamentoService) {
        this.unidadDepartamentoService = unidadDepartamentoService;
    }

    @Operation(summary = "Retorna el listado de todas las unidades de departamento")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UnidadDepartamentoDTO>> getAll() {
        UnidadDepartamentoDTO unidadDepartamentoDTO = new UnidadDepartamentoDTO();
        return new ResponseEntity<>( unidadDepartamentoService.findAll(unidadDepartamentoDTO), HttpStatus.OK);
    }
}
