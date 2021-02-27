package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedentePersonalDTO;
import com.espe.salud.service.antecedente.AntecedentePersonalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_PER;

@RestController
@Tag(description = "Gestiona los antecedentes personales de un paciente", name = "Antecedentes personales")
@RequestMapping(value = {URI_API_V1_ANT_PER})
public class AntecedentePersonalController {
    private final AntecedentePersonalService antecedentePersonalService;

    @Autowired
    public AntecedentePersonalController(AntecedentePersonalService antecedentePersonalService) {
        this.antecedentePersonalService = antecedentePersonalService;
    }

    @Operation(summary = "Retorna el antecedente personal de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePersonalDTO> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return antecedentePersonalService.findByPaciente(idPaciente)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Retorna un antecedente personal por su id")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePersonalDTO> findByCodigo(@PathVariable Long id) {
        return antecedentePersonalService.findById(id)
                .map(antecedente -> new ResponseEntity<>(antecedente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Actualizar un antecedente personla por su id")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePersonalDTO> update(
            @RequestBody AntecedentePersonalDTO antecedentePersonalDTO,
            @Parameter(description = "El ID del antecedente personal", required = true, example = "1")
            @PathVariable Long id) {
        Optional<AntecedentePersonalDTO> optional = antecedentePersonalService.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            AntecedentePersonalDTO nuevo = optional.get();
            nuevo.setOrientacionSexual(antecedentePersonalDTO.getOrientacionSexual());
            nuevo.setIdentidadGenero(antecedentePersonalDTO.getIdentidadGenero());
            nuevo.setPoseeAlergia(antecedentePersonalDTO.getPoseeAlergia());
            nuevo.setDescripcionAlergia(antecedentePersonalDTO.getDescripcionAlergia());
            nuevo.setFrecuenciaAlimentacion(antecedentePersonalDTO.getFrecuenciaAlimentacion());
            nuevo.setPredominioAlimentario(antecedentePersonalDTO.getPredominioAlimentario());
            nuevo.setHoraSuenio(antecedentePersonalDTO.getHoraSuenio());
            nuevo.setHoraDespertar(antecedentePersonalDTO.getHoraDespertar());
            nuevo.setObservacionAlimentacion(antecedentePersonalDTO.getObservacionAlimentacion());
            nuevo.setObservacionHabitoSuenio(antecedentePersonalDTO.getObservacionHabitoSuenio());
            return new ResponseEntity<>(antecedentePersonalService.update(nuevo), HttpStatus.OK) ;
        }
    }

    @Operation(summary = "Guarda un nuevo antecedente personal")
    @PostMapping("/")
    public ResponseEntity<AntecedentePersonalDTO> save(@RequestBody AntecedentePersonalDTO antecedentePersonal){
        return new ResponseEntity<>(antecedentePersonalService.save(antecedentePersonal), HttpStatus.CREATED);
    }
}
