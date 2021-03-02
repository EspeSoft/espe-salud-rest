package com.espe.salud.app.api.v1.evolucion;

import static com.espe.salud.app.common.Constants.URI_API_V1_EVO;

import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.service.evolucion.EvolucionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

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

    @GetMapping(value = "/reporte/certificado-medico/pdf")
    public ResponseEntity<Object> generateCertificadoMedicoGeneral(
            @RequestParam String idEvolucion) {
        byte[] pdfContent = evolucionService.getCertificadoMedico(idEvolucion);
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline; filename=" + idEvolucion + ".pdf");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok().headers(headers).contentLength(pdfContent.length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new ByteArrayInputStream(pdfContent)));
    }
}
