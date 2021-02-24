package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedentePersonalDTO;
import com.espe.salud.service.antecedente.AntecedentePersonalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_PER;

@RestController
@Tag(name = "Gestiona los Antecedentes personales")
@RequestMapping(value = {URI_API_V1_ANT_PER})
public class AntecedentePersonalController {
    private final AntecedentePersonalService antecedentePersonalService;

    @Autowired
    public AntecedentePersonalController(AntecedentePersonalService antecedentePersonalService) {
        this.antecedentePersonalService = antecedentePersonalService;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes personales ")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedentePersonalDTO>> getAll() {
        return new ResponseEntity<>( antecedentePersonalService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente personal  por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePersonalDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity( antecedentePersonalService.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePersonalDTO> update(@RequestBody AntecedentePersonalDTO antecedentePersonalDTO, @RequestParam Long codigo) {
        Optional<AntecedentePersonalDTO> newAntecedentePersonalDTOoptional = antecedentePersonalService.findByCodigo(codigo);
        AntecedentePersonalDTO newAntecedentePersonalDTO = newAntecedentePersonalDTOoptional.get();
        newAntecedentePersonalDTO.setOrientacionSexual(antecedentePersonalDTO.getOrientacionSexual());
        newAntecedentePersonalDTO.setIdentidadGenero(antecedentePersonalDTO.getIdentidadGenero());
        newAntecedentePersonalDTO.setPoseeAlergia(antecedentePersonalDTO.getPoseeAlergia());
        newAntecedentePersonalDTO.setDescripcionAlergia(antecedentePersonalDTO.getDescripcionAlergia());
        newAntecedentePersonalDTO.setTomaMedicacion(antecedentePersonalDTO.getTomaMedicacion());
        newAntecedentePersonalDTO.setRealizaActividadFisica(antecedentePersonalDTO.getRealizaActividadFisica());
        newAntecedentePersonalDTO.setFrecuenciaAlimentacion(antecedentePersonalDTO.getFrecuenciaAlimentacion());
        newAntecedentePersonalDTO.setPredominioAlimentario(antecedentePersonalDTO.getPredominioAlimentario());
        newAntecedentePersonalDTO.setHoraSuenio(antecedentePersonalDTO.getHoraSuenio());
        newAntecedentePersonalDTO.setHoraDespertar(antecedentePersonalDTO.getHoraDespertar());
        newAntecedentePersonalDTO.setObservacionAlimentacion(antecedentePersonalDTO.getObservacionAlimentacion());
        newAntecedentePersonalDTO.setObservacionHabitoSuenio(antecedentePersonalDTO.getObservacionHabitoSuenio());
        return new ResponseEntity<>(antecedentePersonalService.update(newAntecedentePersonalDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente personal")
    @PostMapping("/")
    public ResponseEntity<AntecedentePersonalDTO> save(@RequestBody AntecedentePersonalDTO antecedentePersonal){
        return new ResponseEntity<>(antecedentePersonalService.save(antecedentePersonal), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente personal por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        antecedentePersonalService.delete(codigo);
    }


}
