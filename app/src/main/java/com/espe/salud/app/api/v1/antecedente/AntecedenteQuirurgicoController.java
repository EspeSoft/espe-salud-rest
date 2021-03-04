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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANTE_QUIRURGICO;

@RestController
@Tag(description = "Gestiona antecedente quirurgico", name = "Antecedentes quirúrgicos")
@RequestMapping(value = {URI_API_V1_ANTE_QUIRURGICO})
public class AntecedenteQuirurgicoController {

    private final AntecedenteQuirurgicoService service;

    @Autowired
    public AntecedenteQuirurgicoController(AntecedenteQuirurgicoService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes patologicos familiares de un antecedente personal")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteQuirurgicoDTO>> getByCodigoAntecedentePersonal(@RequestParam Long idAntecedentePersonal) {
        return new ResponseEntity<>(service.findByIdAntecedente(idAntecedentePersonal), HttpStatus.OK);
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes quirurgicos")
    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteQuirurgicoDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente quirurgico por su codigo")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteQuirurgicoDTO> getById(@Parameter(description = "El codigo del antecedente quirurgico", required = true, example = "1") @PathVariable("codigo") Long id) {
        return new ResponseEntity(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente quirurgico por su codigo")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteQuirurgicoDTO> update(@RequestBody AntecedenteQuirurgicoDTO dto, @RequestParam Long codigo) {

        Optional<AntecedenteQuirurgicoDTO> newAntecedenteQuirurgicoDTOoptional = service.findById(codigo);
        AntecedenteQuirurgicoDTO newAntecedenteQuirurgicoDTO = newAntecedenteQuirurgicoDTOoptional.get();
        newAntecedenteQuirurgicoDTO.setDiagnosticoPreQuirurgico(dto.getDiagnosticoPreQuirurgico());
        newAntecedenteQuirurgicoDTO.setProcedimientoQuirurgico(dto.getProcedimientoQuirurgico());
        newAntecedenteQuirurgicoDTO.setFechaProcedimiento(dto.getFechaProcedimiento());
        newAntecedenteQuirurgicoDTO.setSecuelas(dto.getSecuelas());
        newAntecedenteQuirurgicoDTO.setIdAntecedentePersonal(dto.getIdAntecedentePersonal());
        return new ResponseEntity<>(service.update(newAntecedenteQuirurgicoDTO), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar un nuevo antecedente quirurgico")
    @PostMapping("/")
    public ResponseEntity<AntecedenteQuirurgicoDTO> save(@RequestBody AntecedenteQuirurgicoDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente quirurgico por su codigo")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        service.deleteById(codigo);
    }
}