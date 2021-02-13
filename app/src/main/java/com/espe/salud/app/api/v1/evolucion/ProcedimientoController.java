package com.espe.salud.app.api.v1.evolucion;

import com.espe.salud.dto.evolucion.ProcedimientoDTO;
import com.espe.salud.service.evolucion.ProcedimientoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.espe.salud.app.common.Constants.URI_API_V1_PRO;

@RestController
@Tag(description = "Gestiona los procedimientos realizados a una nota de enfermería", name = "Procedimientos")
@RequestMapping(value = URI_API_V1_PRO)
public class ProcedimientoController {
    private final ProcedimientoService procedimientoService;

    @Autowired
    public ProcedimientoController (ProcedimientoService procedimientoService){
        this.procedimientoService = procedimientoService;
    }

    @PostMapping("/")
    public ResponseEntity<ProcedimientoDTO> save(@RequestBody ProcedimientoDTO antecedente){
        return new ResponseEntity<>(procedimientoService.save(antecedente), HttpStatus.CREATED);
    }


}
