package com.espe.salud.app.api.v1.evolucion;

import static com.espe.salud.app.common.Constants.URI_API_V1_EVO;

import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.service.evolucion.EvolucionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(description = "Gestiona las evoluciones de un paciente", name = "Evoluciones")
@RequestMapping(value = {URI_API_V1_EVO})
public class EvolucionController {

    private final EvolucionService evolucionService;

    @Autowired
    public EvolucionController(
            EvolucionService evolucionService) {
        this.evolucionService = evolucionService;
    }

    @PostMapping("/")
    public ResponseEntity<EvolucionDTO> save(@RequestBody EvolucionDTO evolucion) {
        return new ResponseEntity<>(evolucionService.save(evolucion), HttpStatus.CREATED);
    }
}
