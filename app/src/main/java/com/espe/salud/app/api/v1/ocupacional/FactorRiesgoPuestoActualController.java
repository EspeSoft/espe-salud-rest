package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.FactorRiesgoPuestoActualDTO;
import com.espe.salud.service.ocupacional.FactorRiesgoPuestoActualService;
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
import static com.espe.salud.app.common.Constants.URI_API_V1_FAC_RIE_PUE_ACT;

@RestController
@Tag(description = "Gestiona los factores de riesgos del puesto actual", name = "Factores de Riesgos del Puesto Actual")
@RequestMapping(value = URI_API_V1_FAC_RIE_PUE_ACT)
public class FactorRiesgoPuestoActualController {
    private final FactorRiesgoPuestoActualService serviceFactor;

    @Autowired
    public FactorRiesgoPuestoActualController(
            @Qualifier("factorRiesgoPuestoActualServiceImpl") FactorRiesgoPuestoActualService serviceFactor
    ) {
        this.serviceFactor = serviceFactor;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FactorRiesgoPuestoActualDTO>> getAll() {
        return new ResponseEntity<>( serviceFactor.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FactorRiesgoPuestoActualDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(serviceFactor.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FactorRiesgoPuestoActualDTO> update(@RequestBody FactorRiesgoPuestoActualDTO antecedenteDTO, @RequestParam Long codigo) {
        Optional<FactorRiesgoPuestoActualDTO> newFactorRiesgoPuestoActualDTOoptional = serviceFactor.findByCodigo(codigo);
        FactorRiesgoPuestoActualDTO newFactorRiesgoPuestoActualDTO = newFactorRiesgoPuestoActualDTOoptional.get();
        return new ResponseEntity<>(serviceFactor.update(newFactorRiesgoPuestoActualDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("/")
    public ResponseEntity<FactorRiesgoPuestoActualDTO> save(@RequestBody FactorRiesgoPuestoActualDTO antecedente){
        return new ResponseEntity<>(serviceFactor.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        serviceFactor.delete(codigo);
    }
}
