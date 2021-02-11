package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
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

import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_EMP_ANT;
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_ENF_PRO;

@RestController
@Tag(name = "Gestiona los antecedentes de empleo anterior de un antecedente laboral")
@RequestMapping(value = URI_API_V1_ANT_ENF_PRO)
public class AntecedenteEnfermedadProfesionalController {

    private final AntecedenteEmpleoAnteriorService antecedenteEmpleoAnteriorService;

    @Autowired
    private AntecedenteEnfermedadProfesionalController(AntecedenteEmpleoAnteriorService antecedenteEmpleoAnteriorService) {
        this.antecedenteEmpleoAnteriorService = antecedenteEmpleoAnteriorService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una antecedente de empleo anterior por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> retrieve(
            @Parameter(description = "El ID del antecedente de empleo anterior", required = true, example = "1")
            @PathVariable("id") Long id) {
        return antecedenteEmpleoAnteriorService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita un antecedente empleo anterior por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> update(@RequestBody AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnteriorDTO, @RequestParam Long codigo) {
        Optional<AntecedenteEmpleoAnteriorDTO> newAntecedenteEmpleoAnteriorDTOoptional = antecedenteEmpleoAnteriorService.findById(codigo);
        AntecedenteEmpleoAnteriorDTO newAntecedenteEmpleoAnteriorDTO = newAntecedenteEmpleoAnteriorDTOoptional.get();
        newAntecedenteEmpleoAnteriorDTO.setEmpresa(antecedenteEmpleoAnteriorDTO.getEmpresa());
        newAntecedenteEmpleoAnteriorDTO.setActividadDesempeñaba(antecedenteEmpleoAnteriorDTO.getActividadDesempeñaba());
        return new ResponseEntity<>(antecedenteEmpleoAnteriorService.update(newAntecedenteEmpleoAnteriorDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente empleo anterior")
    @PostMapping("/")
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> save(@RequestBody AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnterior){
        return new ResponseEntity<>(antecedenteEmpleoAnteriorService.save(antecedenteEmpleoAnterior), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente empleo anterior por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        antecedenteEmpleoAnteriorService.delete(codigo);
    }
    
}
