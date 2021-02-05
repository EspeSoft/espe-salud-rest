package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.catalogo.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.dto.enfermeria.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.service.enfermeria.AntecedenteEmpleoAnteriorService;
import com.espe.salud.service.ocupacional.AntecedenteEmpleoAnteriorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_EMP_ANT;

@RestController
@Tag(name = "Gestiona los antecedentes de empleo anterior de un antecedente laboral")
@RequestMapping(value = URI_API_V1_ANT_EMP_ANT)
public class AntecedenteEmpleoAnteriorController {

    private final AntecedenteEmpleoAnteriorService antecedenteEmpleoAnteriorService;
    
    @Autowired
    private AntecedenteEmpleoAnteriorController(AntecedenteEmpleoAnteriorService antecedenteEmpleoAnteriorService) {
        this.antecedenteEmpleoAnteriorService = antecedenteEmpleoAnteriorService;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes de empleo anteriores")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteEmpleoAnteriorDTO>> getAll() {
        AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnteriorDTO = new AntecedenteEmpleoAnteriorDTO();
        return new ResponseEntity<>( antecedenteEmpleoAnteriorService.findExisting(antecedenteEmpleoAnteriorDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una nota de enfermeria por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> retrieve(
            @Parameter(description = "El ID de la nota de enfermeria", required = true, example = "1")
            @PathVariable("id") Long id) {
        return antecedenteEmpleoAnteriorService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
