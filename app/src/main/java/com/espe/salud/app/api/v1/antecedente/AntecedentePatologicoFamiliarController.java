package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliarDTO;
import com.espe.salud.service.antecedente.AntecedentePatologicoFamiliarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANTE_PAT_FAM;

@RestController
@Tag(description = "Gestiona antecedentes patologicos familiar", name = "Antecedentes patológicos familiares")
@RequestMapping(value = {URI_API_V1_ANTE_PAT_FAM})
public class AntecedentePatologicoFamiliarController {

    private final AntecedentePatologicoFamiliarService service;

    @Autowired
    public AntecedentePatologicoFamiliarController(AntecedentePatologicoFamiliarService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes patologicos familiares")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedentePatologicoFamiliarDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente patologico familiar por su codigo")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoFamiliarDTO> getById(@Parameter(description = "El codigo del antecedente patologico familiar",required = true,example = "1") @PathVariable("codigo") Long id){
        return new ResponseEntity(service.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente patologico familiar por su codigo")
    @PutMapping(value = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoFamiliarDTO> update(@RequestBody AntecedentePatologicoFamiliarDTO dto,@RequestParam Long codigo){
        Optional<AntecedentePatologicoFamiliarDTO> newAntecedentePatologicoFamiliarDTOoptional=service.findById(codigo);
        AntecedentePatologicoFamiliarDTO newAntecedentePatologicoFamiliaDTO= newAntecedentePatologicoFamiliarDTOoptional.get();
        newAntecedentePatologicoFamiliaDTO.setDiagnostico(dto.getDiagnostico());
        newAntecedentePatologicoFamiliaDTO.setObservacion(dto.getObservacion());
        newAntecedentePatologicoFamiliaDTO.setParentezco(dto.getParentezco());
        newAntecedentePatologicoFamiliaDTO.setTipoEnfermedad(dto.getTipoEnfermedad());
        return new ResponseEntity<>(service.update(newAntecedentePatologicoFamiliaDTO),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar un nuevo antecedente patologico familiar")
    @PostMapping("/")
    public ResponseEntity<AntecedentePatologicoFamiliarDTO> save(@RequestBody AntecedentePatologicoFamiliarDTO dto){
        return new ResponseEntity<>(service.save(dto),HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente patologico familiar por su codigo")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        service.deleteById(codigo);
    }
}