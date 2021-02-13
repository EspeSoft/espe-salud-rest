package com.espe.salud.app.api.v1.evolucion;

import com.espe.salud.dto.evolucion.DiagnosticoDTO;
import com.espe.salud.service.evolucion.DiagnosticoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/")
    public ResponseEntity<DiagnosticoDTO> save(@RequestBody DiagnosticoDTO antecedente){
        return new ResponseEntity<>(diagnosticoService.save(antecedente), HttpStatus.CREATED);
    }
}
