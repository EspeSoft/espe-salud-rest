package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.AntecedenteGinecologicoDTO;
import com.espe.salud.service.antecedente.AntecedenteGinecologicoService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ANTGIN;

@RestController
@Tag(name = "Gestiona antecedentes ginecológicos")
@RequestMapping(value = {URI_API_V1_ANTGIN})
public class AntecedenteGinecologicoController {

    private final AntecedenteGinecologicoService service;

    @Autowired
    public AntecedenteGinecologicoController(AntecedenteGinecologicoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes ginecológicos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteGinecologicoDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente ginecológico por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteGinecologicoDTO> getById(@Parameter(description = "El codigo del antecedente ginecológico",required = true,example = "1") @PathVariable("codigo") Long id){
        return new ResponseEntity(service.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Edita un anecedente ginecológico por su codigo")
    @PutMapping(value = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteGinecologicoDTO> update(@RequestBody AntecedenteGinecologicoDTO dto,@RequestParam Long codigo){
        Optional<AntecedenteGinecologicoDTO> newAntecedenteGinecologicoDTOoptional=service.findById(codigo);
        AntecedenteGinecologicoDTO newAntecedenteGinecologicoDTO= newAntecedenteGinecologicoDTOoptional.get();
        newAntecedenteGinecologicoDTO.setCicloMenstruacion(dto.getCicloMenstruacion());
        newAntecedenteGinecologicoDTO.setFechaUltimaMenstruacion(dto.getFechaUltimaMenstruacion());
        newAntecedenteGinecologicoDTO.setGestas(dto.getGestas());
        newAntecedenteGinecologicoDTO.setNumeroPartosVaginales(dto.getNumeroPartosVaginales());
        newAntecedenteGinecologicoDTO.setNumeroCesareas(dto.getNumeroCesareas());
        newAntecedenteGinecologicoDTO.setNumeroAbortos(dto.getNumeroAbortos());
        return new ResponseEntity<>(service.update(newAntecedenteGinecologicoDTO),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar un nuevo antecedente ginecológico")
    @PostMapping("/")
    public ResponseEntity<AntecedenteGinecologicoDTO> save(@RequestBody AntecedenteGinecologicoDTO dto){
        return new ResponseEntity<>(service.save(dto),HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente ginecológico por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        service.deleteById(codigo);
    }
}
