package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.service.ocupacional.AntecedenteEmpleoAnteriorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_ACC_TRA;
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_EMP_ANT;

@RestController
@Tag(description = "Gestiona los antecedentes de empleos anteriores", name = "Antecedentes de Empleos Anteriores")
@RequestMapping(value = URI_API_V1_ANT_EMP_ANT)
public class AntecedenteEmpleoAnteriorController {
    private final AntecedenteEmpleoAnteriorService serviceAntecedente;

    @Autowired
    public AntecedenteEmpleoAnteriorController(
            @Qualifier("antecedenteEmpleoAnteriorServiceImpl") AntecedenteEmpleoAnteriorService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteEmpleoAnteriorDTO>> getAll() {
        return new ResponseEntity<>( serviceAntecedente.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> update(@RequestBody AntecedenteEmpleoAnteriorDTO antecedenteDTO, @RequestParam Long codigo) {
        Optional<AntecedenteEmpleoAnteriorDTO> newAntecedenteEmpleoAnteriorDTOoptional = serviceAntecedente.findByCodigo(codigo);
        AntecedenteEmpleoAnteriorDTO newAntecedenteEmpleoAnteriorDTO = newAntecedenteEmpleoAnteriorDTOoptional.get();
        newAntecedenteEmpleoAnteriorDTO.setActividad(antecedenteDTO.getActividad());
        newAntecedenteEmpleoAnteriorDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteEmpleoAnteriorDTO.setMeses(antecedenteDTO.getMeses());
        newAntecedenteEmpleoAnteriorDTO.setObservacion(antecedenteDTO.getObservacion());
        newAntecedenteEmpleoAnteriorDTO.setPuestoTrabajo(antecedenteDTO.getPuestoTrabajo());
        newAntecedenteEmpleoAnteriorDTO.setUsabanSeguridad(antecedenteDTO.getUsabanSeguridad());
        newAntecedenteEmpleoAnteriorDTO.setVigilanciaSalud(antecedenteDTO.getVigilanciaSalud());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteEmpleoAnteriorDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("/")
    public ResponseEntity<AntecedenteEmpleoAnteriorDTO> save(@RequestBody AntecedenteEmpleoAnteriorDTO antecedente){
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        serviceAntecedente.delete(codigo);
    }
}
