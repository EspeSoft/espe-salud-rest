package com.espe.salud.app.api.v1.evolucion;

import com.espe.salud.dto.evolucion.DiagnosticoDTO;
import com.espe.salud.service.evolucion.DiagnosticoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_DIA;

@RestController
@Tag(description = "Gestiona los diagnostico de antecedentes", name = "Diagnósticos")
@RequestMapping(value = URI_API_V1_DIA)
public class DiagnosticoController {
    private final DiagnosticoService  diagnosticoService;

    @Autowired
    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @Operation(summary = "Retorna el listado de todos los diagnosticos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DiagnosticoDTO>> getAll() {
        return new ResponseEntity<>( diagnosticoService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un diagnostico por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiagnosticoDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity( diagnosticoService.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un diagnostico por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiagnosticoDTO> update(@RequestBody DiagnosticoDTO diagnosticoDTO, @RequestParam Long codigo) {
        Optional<DiagnosticoDTO> newDiagnosticoDTOoptional = diagnosticoService.findByCodigo(codigo);
        DiagnosticoDTO newDiagnosticoDTO = newDiagnosticoDTOoptional.get();
        newDiagnosticoDTO.setCodigoCIE(diagnosticoDTO.getCodigoCIE());
        newDiagnosticoDTO.setPrevencion(diagnosticoDTO.getPrevencion());
        newDiagnosticoDTO.setMorbilidad(diagnosticoDTO.getMorbilidad());
        newDiagnosticoDTO.setCondicionDiagnostico(diagnosticoDTO.getCondicionDiagnostico());
        return new ResponseEntity<>(diagnosticoService.update(newDiagnosticoDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo diagnostico")
    @PostMapping("/")
    public ResponseEntity<DiagnosticoDTO> save(@RequestBody DiagnosticoDTO diagnostico){
        return new ResponseEntity<>(diagnosticoService.save(diagnostico), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un diagnostico por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        diagnosticoService.delete(codigo);
    }

}
