package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.MotivoAtencion;
import com.espe.salud.dto.catalogo.MotivoAtencionDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_MOT_ATE;

@RestController
@RequestMapping(value = {URI_API_V1_MOT_ATE})
@Tag(description = "Gestiona el catálogo de motivos de atención", name = "Motivos de atención")
public class MotivoAtencionController {
    private final GenericCRUDService<MotivoAtencion, MotivoAtencionDTO> motivoAtencionService;

    @Autowired
    public MotivoAtencionController(
            @Qualifier("motivoAtencionServiceImpl") GenericCRUDService<MotivoAtencion, MotivoAtencionDTO> motivoAtencionService) {
        this.motivoAtencionService = motivoAtencionService;
    }

    @Operation(summary = "Retorna el listado de todos los motivos de atención en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MotivoAtencionDTO>> getAll() {
        return new ResponseEntity<>(motivoAtencionService.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un motivo de atención por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<MotivoAtencionDTO> retrieve(
            @Parameter(description = "El ID del motivo de atención", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(motivoAtencionService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo motivo de atención")
    public ResponseEntity<MotivoAtencionDTO> save(@RequestBody MotivoAtencionDTO motivoAtencionDTO) {
        return new ResponseEntity<>(motivoAtencionService.saveOrUpdate(motivoAtencionDTO), HttpStatus.CREATED);
    }

}
