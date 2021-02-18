package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.GrupoCulturalDTO;
import com.espe.salud.service.catalogo.GrupoCulturalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_GRU_CUL;

@RestController
@RequestMapping(value = {URI_API_V1_GRU_CUL})
@Tag(description = "Gestiona los grupos culturales", name = "Grupos cultural")
public class GrupoCulturalController {

    private final GrupoCulturalService grupoCulturalService;

    public GrupoCulturalController(GrupoCulturalService grupoCulturalService) {
        this.grupoCulturalService = grupoCulturalService;
    }

    @Operation(summary = "Retorna el listado de los grupos culturales")
    @GetMapping(value = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<GrupoCulturalDTO>> getAll(){
        return new ResponseEntity<>(grupoCulturalService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un grupo cultural por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<GrupoCulturalDTO> getById(
            @Parameter(description = "El ID del grupo cultural", required = true, example = "1")
            @PathVariable("id") Long id) {
        return grupoCulturalService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
