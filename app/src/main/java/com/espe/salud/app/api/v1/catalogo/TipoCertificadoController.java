package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoCertificado;
import com.espe.salud.dto.catalogo.TipoCertificadoDTO;
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

import javax.validation.Valid;
import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIPCER;

@RestController
@RequestMapping(value = {URI_API_V1_TIPCER})
@Tag(description = "Gestiona el cátalogo de tipos de certificados médicos", name = "Tipos de certificado médico")
public class TipoCertificadoController {

    private final GenericCRUDService<TipoCertificado, TipoCertificadoDTO> tipocertificadoService;

    @Autowired
    public TipoCertificadoController(
            @Qualifier("tipoCertificadoServiceImpl") GenericCRUDService<TipoCertificado, TipoCertificadoDTO> tipocertificadoService) {
        this.tipocertificadoService = tipocertificadoService;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de certificado en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoCertificadoDTO>> getAll() {
        return new ResponseEntity<>(tipocertificadoService.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un tipo de certificado por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<TipoCertificadoDTO> retrieve(
            @Parameter(description = "El ID del tipo de certificado", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(tipocertificadoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo tipo de certificado")
    public ResponseEntity<TipoCertificadoDTO> save(@Valid @RequestBody TipoCertificadoDTO tipoCertificadoDTO) {
        return new ResponseEntity<>(tipocertificadoService.saveOrUpdate(tipoCertificadoDTO), HttpStatus.CREATED);
    }
}
