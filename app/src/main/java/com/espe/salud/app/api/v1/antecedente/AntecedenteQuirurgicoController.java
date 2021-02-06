package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;
import com.espe.salud.service.antecedente.AntecedenteQuirurgicoService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ANTE_QUIRURGICO;

@RestController
@Tag(name = "Gestiona antecedente quirurgico")
@RequestMapping(value = {URI_API_V1_ANTE_QUIRURGICO})
public class AntecedenteQuirurgicoController {

    private final AntecedenteQuirurgicoService service;

    @Autowired
    public AntecedenteQuirurgicoController(AntecedenteQuirurgicoService service) {
        this.service = service;
    }
    @Operation(summary = "Retorna el listado de todos los antecedentes quirurgicos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteQuirurgicoDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente quirurgico por su codigo")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteQuirurgicoDTO> getById(@Parameter(description = "El codigo del antecedente quirurgico",required = true,example = "1") @PathVariable("codigo") Long id){
        return new ResponseEntity(service.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente quirurgico por su codigo")
    @PutMapping(value = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteQuirurgicoDTO> update(@RequestBody AntecedenteQuirurgicoDTO dto,@RequestParam Long codigo){

        Optional<AntecedenteQuirurgicoDTO> newAntecedenteQuirurgicoDTOoptional=service.findById(codigo);
        AntecedenteQuirurgicoDTO newAntecedenteQuirurgicoDTO=newAntecedenteQuirurgicoDTOoptional.get();
        newAntecedenteQuirurgicoDTO.setDiagnosticoPreQuirurgico(dto.getDiagnosticoPreQuirurgico());
        newAntecedenteQuirurgicoDTO.setProcedimientoQuirurgico(dto.getProcedimientoQuirurgico());
        newAntecedenteQuirurgicoDTO.setFechaProcedimiento(dto.getFechaProcedimiento());
        newAntecedenteQuirurgicoDTO.setSecuelas(dto.getSecuelas());
        return new ResponseEntity<>(service.update(newAntecedenteQuirurgicoDTO),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar un nuevo antecedente quirurgico")
    @PostMapping("/")
    public ResponseEntity<AntecedenteQuirurgicoDTO> save(@RequestBody AntecedenteQuirurgicoDTO dto){
        return new ResponseEntity<>(service.save(dto),HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente quirurgico por su codigo")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        service.deleteById(codigo);
    }
}