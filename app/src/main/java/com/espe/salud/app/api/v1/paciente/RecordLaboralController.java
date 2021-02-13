package com.espe.salud.app.api.v1.paciente;

import com.espe.salud.dto.paciente.RecordLaboralDTO;
import com.espe.salud.service.paciente.RecordLaboralService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.espe.salud.app.common.Constants.URI_API_V1_REC_LAB;

@RestController
@Tag(description = "Gestiona los records laborales de un paciente", name = "Records laborales")
@RequestMapping(value = URI_API_V1_REC_LAB)
public class RecordLaboralController {
    private final RecordLaboralService recordLaboralService;

    @Autowired
    public RecordLaboralController(RecordLaboralService recordLaboralService) {
        this.recordLaboralService = recordLaboralService;
    }

    @PostMapping("/")
    public ResponseEntity<RecordLaboralDTO> save(@RequestBody RecordLaboralDTO antecedente){
        return new ResponseEntity<>(recordLaboralService.save(antecedente), HttpStatus.CREATED);
    }
}
