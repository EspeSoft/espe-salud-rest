package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteLaboralDTO;
import com.espe.salud.service.ocupacional.AntecedenteLaboralService;
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
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_LAB;

@RestController
@Tag(description = "Gestiona los antecedentes laborales", name = "Antecedentes Laborales")
@RequestMapping(value = URI_API_V1_ANT_LAB)
public class AntecedenteLaboralController {
    private final AntecedenteLaboralService serviceAntecedente;

    @Autowired
    public AntecedenteLaboralController(
            @Qualifier("antecedenteLaboralServiceImpl") AntecedenteLaboralService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteLaboralDTO>> getAll() {
        return new ResponseEntity<>( serviceAntecedente.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteLaboralDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteLaboralDTO> update(@RequestBody AntecedenteLaboralDTO antecedenteDTO, @RequestParam Long codigo) {
        Optional<AntecedenteLaboralDTO> newAntecedenteLaboralDTOoptional = serviceAntecedente.findByCodigo(codigo);
        AntecedenteLaboralDTO newAntecedenteLaboralDTO = newAntecedenteLaboralDTOoptional.get();
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteLaboralDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("/")
    public ResponseEntity<AntecedenteLaboralDTO> save(@RequestBody AntecedenteLaboralDTO antecedente){
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        serviceAntecedente.delete(codigo);
    }
}
