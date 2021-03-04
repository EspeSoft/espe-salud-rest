package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.RepertorioMedicamento;
import com.espe.salud.dto.catalogo.RepertorioMedicamentoDTO;
import com.espe.salud.dto.enfermeria.ActividadEnfermeriaDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_REP_MED;

@RestController
@RequestMapping(value = {URI_API_V1_REP_MED})
@Tag(description = "Gestiona el catálogo de repertorios de medicamentos", name = "Repertorios de medicamentos")
public class RepertorioMedicamentoController {
    private final GenericCRUDService<RepertorioMedicamento, RepertorioMedicamentoDTO> service;

    @Autowired
    public RepertorioMedicamentoController(
            @Qualifier("repertorioMedicacionImpl") GenericCRUDService<RepertorioMedicamento, RepertorioMedicamentoDTO> service) {
        this.service = service;
    }


    @Operation(summary = "Retorna el listado de todos los repertorios de medicamentos en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RepertorioMedicamentoDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un medicamento por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<RepertorioMedicamentoDTO> getById(
            @Parameter(description = "El ID del medicamento", required = true, example = "1")
            @PathVariable("id") Long id) {
        return  new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo repertorio de medicamento")
    public ResponseEntity<RepertorioMedicamentoDTO> save(@RequestBody RepertorioMedicamentoDTO dto){
        return new ResponseEntity<>(service.saveOrUpdate(dto), HttpStatus.CREATED);
    }
}
