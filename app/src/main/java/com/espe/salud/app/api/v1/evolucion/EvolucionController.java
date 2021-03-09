package com.espe.salud.app.api.v1.evolucion;

import static com.espe.salud.app.common.Constants.URI_API_V1_EVO;

import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.dto.evolucion.ReposoDTO;
import com.espe.salud.service.evolucion.EvolucionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<EvolucionDTO> save(@Valid @RequestBody EvolucionDTO evolucion) {
        return new ResponseEntity<>(evolucionService.save(evolucion), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una evolución por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<EvolucionDTO> getById(
            @Parameter(description = "El ID de la evolución", required = true, example = "EV_0000001")
            @PathVariable("id") String id) {
        return evolucionService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Elimina una Evolución por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(required = true, description = "El ID de la evolución", example = "EV_0000001")
            @PathVariable String id) {
        return new ResponseEntity<>(evolucionService.delete(id), HttpStatus.OK);
    }

    @Operation(summary = "Retorna las evoluciones de un usuario")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/usuario", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EvolucionDTO>> getByUsuario(
            @Parameter(required = true, description = "El ID del usuario", example = "62455")
            @RequestParam Long idUsuario) {
        return new ResponseEntity<>( evolucionService.findByUsuario(idUsuario), HttpStatus.OK);
    }

    @Operation(summary = "Retorna las evoluciones de un paciente")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/paciente", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EvolucionDTO>> getByPaciente(
            @Parameter(required = true, description = "El ID del paciente", example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>( evolucionService.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una evolución ")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<EvolucionDTO> update(
            @Valid @RequestBody EvolucionDTO dto,
            @Parameter(description = "El ID de la evolución ", required = true, example = "1")
            @PathVariable("id") String id) {
        Optional<EvolucionDTO> optional = evolucionService.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>( evolucionService.update(dto), HttpStatus.OK);
        }
    }

    @Operation(summary = "Retorna un pdf de certificado médico")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/reporte/certificado-medico/pdf")
    public ResponseEntity<Object> generateCertificadoMedicoGeneral(
            @Parameter(description = "El ID de la evolución", required = true, example = "EV_0000001")
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

    @Operation(summary = "Retorna una receta médica en formato pdf")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/reporte/receta-medica/pdf")
    public ResponseEntity<Object> generateRecetaMedica(
            @Parameter(description = "El ID de la evolución", required = true, example = "EV_0000001")
            @RequestParam String idEvolucion) {
        byte[] pdfContent = evolucionService.getRecetaMedica(idEvolucion);
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline; filename=" + idEvolucion + ".pdf");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok().headers(headers).contentLength(pdfContent.length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new ByteArrayInputStream(pdfContent)));
    }

    @Operation(summary = "Retorna un pdf de un certificado de reposo")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/reporte/certificado-reposo/pdf")
    public ResponseEntity<Object> generateCertificadoReposo(
            @Valid
            @Parameter(description = "El ID de la evolución", required = true, example = "EV_0000001")
            @RequestParam String idEvolucion,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin,
            @RequestParam String condicionPaciente,
            @RequestParam String recomendacion) {
        byte[] pdfContent = evolucionService.getCertificadoReposo(fechaInicio, fechaFin, condicionPaciente, recomendacion, idEvolucion);
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
