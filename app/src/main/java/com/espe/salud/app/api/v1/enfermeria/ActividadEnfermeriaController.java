package com.espe.salud.app.api.v1.enfermeria;

import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;
import com.espe.salud.service.enfermeria.ActividadEnfermeriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ACT_ENF;

@RestController
    @Tag(description = "Gestiona las actividades de enfermería de un paciente", name = "Actividades Enfermería")
@RequestMapping(value = {URI_API_V1_ACT_ENF})
public class ActividadEnfermeriaController {
    private final ActividadEnfermeriaService actividadEnfermeriaService;

    @Autowired
    public ActividadEnfermeriaController(ActividadEnfermeriaService actividadEnfermeriaService) {
        this.actividadEnfermeriaService = actividadEnfermeriaService;
    }


//    @Operation(summary = "Retorna las actividades de enfermería de un usuario")
//    @ApiResponse(responseCode = "200", description = "OK")
//    @GetMapping(value = "/usuario", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<List<ActividadEnfermeriaDTO>> getByUsuario(
//            @Parameter(required = true, description = "El ID del usuario", example = "1") @RequestParam Long usuario) {
//        return new ResponseEntity<>( actividadEnfermeriaService.findByUsuario(usuario), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una actividad de enfermería por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ActividadEnfermeriaDTO> findByCodigo(
            @Parameter(description = "El ID de la actividad de enfermería", required = true, example = "1")
            @PathVariable("id") Long id) {
        return actividadEnfermeriaService.findById(id)
                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nueva actividad de enfermería")
    public ResponseEntity<ActividadEnfermeriaDTO> save(@RequestBody ActividadEnfermeriaDTO actividadEnfermeriaDTO){
        return new ResponseEntity<>(actividadEnfermeriaService.save(actividadEnfermeriaDTO), HttpStatus.CREATED);
    }

//    @GetMapping("/{idPaciente}")
//    @Operation(summary = "Retorna una actividad de enfermería por su PacienteId")
//    @ApiResponse(responseCode = "200", description = "OK")
//    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
//    public ResponseEntity<ActividadEnfermeriaDTO> findByPaciente(
//            @Parameter(description = "El pacienteId de la actividad de enfermería", required = true, example = "1")
//            @PathVariable("idPaciente") Long idPaciente) {
//        return actividadEnfermeriaService.findByPaciente(idPaciente)
//                .map(nota -> new ResponseEntity<>(nota, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    @Operation(summary = "Retorna el listado de todas las actividades de enfermería")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ActividadEnfermeriaDTO>> getAll() {
        return new ResponseEntity<>( actividadEnfermeriaService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Elimina una Actividad de Enfermería por su id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        actividadEnfermeriaService.delete(id);
    }




}