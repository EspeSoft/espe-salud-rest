package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import com.espe.salud.dto.antecedente.EstudioComplementarioDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_EST_COM;

@RestController
@RequestMapping(value = {URI_API_V1_EST_COM})
@Tag(description = "Gestiona el catálogo de estudios complementarios", name = "Estudios complentarios")
public class EstudioComplementarioController {

    private final GenericCRUDService<EstudioComplementario, EstudioComplementarioDTO> estudioComplementarioService;

    @Autowired
    public EstudioComplementarioController(
            @Qualifier("estudioComplementarioServiceImpl") GenericCRUDService<EstudioComplementario, EstudioComplementarioDTO> estudioComplementarioService) {
        this.estudioComplementarioService = estudioComplementarioService;
    }

    @Operation(summary = "Retorna el listado de todos los estudios complementarios")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EstudioComplementarioDTO>> getAll() {
        EstudioComplementarioDTO estudioComplementarioDTO = new EstudioComplementarioDTO();
        return new ResponseEntity<>( estudioComplementarioService.findAll(estudioComplementarioDTO), HttpStatus.OK);
    }

}
