package com.espe.salud.app.api.v1.enfermeria;

import com.espe.salud.dto.enfermeria.NotaEnfermeriaDTO;
import com.espe.salud.service.enfermeria.NotaEnfermeriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_NOT_ENF;

@RestController
@Tag(name = "Gestiona las notas de enfermeria de un paciente")
@RequestMapping(value = {URI_API_V1_NOT_ENF})
public class NotaEnfermeriaController {
    private final NotaEnfermeriaService notaEnfermeriaService;

    @Autowired
    private NotaEnfermeriaController(NotaEnfermeriaService notaEnfermeriaService) {
        this.notaEnfermeriaService = notaEnfermeriaService;
    }

    @Operation(summary = "Retorna las notas de enfermeria de un paciente")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NotaEnfermeriaDTO>> getByPaciente(
            @Parameter(required = true, description = "El ID del paciente", example = "1") @RequestParam Long paciente) {
        return new ResponseEntity<>( notaEnfermeriaService.findByPaciente(paciente), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una nota de enfermeria por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<NotaEnfermeriaDTO> retrieve(
            @Parameter(description = "El ID de la nota de enfermeria", required = true, example = "1")
            @PathVariable("id") Long id) {
        return notaEnfermeriaService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
