package com.espe.salud.app.api.v1.antecedente;


import com.espe.salud.dto.antecedente.AntecedentePatologicoPersonalDTO;
import com.espe.salud.service.antecedente.AntecedentePatologicoPersonalService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_PATOLOGICO_PERSONAL;

@RestController
@Tag(description = "Gestiona antecedentes patologicos personales", name = "Antecedentes patológicos personales")
@RequestMapping(value = {URI_API_V1_ANT_PATOLOGICO_PERSONAL})
public class AntecedentePatologicoPersonalController {

    private final AntecedentePatologicoPersonalService service;

    @Autowired
    public AntecedentePatologicoPersonalController(AntecedentePatologicoPersonalService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes patologicos personales")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedentePatologicoPersonalDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente patologico personal por su codigo")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoPersonalDTO> getById(@Parameter(description = "El codigo del antecedente patologico personal",required = true,example = "1") @PathVariable("codigo") Long id){
        return new ResponseEntity(service.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente patologico personal por su codigo")
    @PutMapping(value = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedentePatologicoPersonalDTO> update(@RequestBody AntecedentePatologicoPersonalDTO dto,@RequestParam Long codigo){

        Optional<AntecedentePatologicoPersonalDTO> optional=service.findById(codigo);
        AntecedentePatologicoPersonalDTO personalDTO= optional.get();
        personalDTO.setIdAntecedentePersonal(dto.getIdAntecedentePersonal());
        personalDTO.setTomaMedicacion(dto.getTomaMedicacion());
        personalDTO.setTipoEnfermedadPersonal(dto.getTipoEnfermedadPersonal());
        personalDTO.setDiagnostico(dto.getDiagnostico());
        personalDTO.setFechaDiagnostico(dto.getFechaDiagnostico());
        return new ResponseEntity<>(service.update(personalDTO),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar un nuevo antecedente patologico personal")
    @PostMapping("/")
    public ResponseEntity<AntecedentePatologicoPersonalDTO> save(@RequestBody AntecedentePatologicoPersonalDTO dto){
        return new ResponseEntity<>(service.save(dto),HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente patologico personal por su codigo")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        service.deleteById(codigo);
    }
}
