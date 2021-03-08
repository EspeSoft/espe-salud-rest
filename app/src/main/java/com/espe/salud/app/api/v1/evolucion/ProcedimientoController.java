package com.espe.salud.app.api.v1.evolucion;

import com.espe.salud.dto.evolucion.ProcedimientoDTO;
import com.espe.salud.service.evolucion.ProcedimientoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_PRO;

@RestController
@Tag(description = "Gestiona los procedimientos realizados a una nota de enfermería", name = "Procedimientos")
@RequestMapping(value = URI_API_V1_PRO)
public class ProcedimientoController {
    private final ProcedimientoService procedimientoService;

    @Autowired
    public ProcedimientoController(ProcedimientoService procedimientoService) {
        this.procedimientoService = procedimientoService;
    }

    @Operation(summary = "Retorna el listado de todos los procedimientos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProcedimientoDTO>> getAll() {
        return new ResponseEntity<>(procedimientoService.findAll(), HttpStatus.OK);
    }


    @Operation(summary = "Retorna un procedimiento por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProcedimientoDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(procedimientoService.findById(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un procedimiento por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProcedimientoDTO> update(@RequestBody ProcedimientoDTO procedimientoDTO, @RequestParam Long codigo) {
        Optional<ProcedimientoDTO> newProcedimientoDTOoptional = procedimientoService.findById(codigo);
        ProcedimientoDTO newProcedimientoDTO = newProcedimientoDTOoptional.get();
        newProcedimientoDTO.setTipoProcedimiento(procedimientoDTO.getTipoProcedimiento());
        newProcedimientoDTO.setNumeroActividades(procedimientoDTO.getNumeroActividades());
        newProcedimientoDTO.setNota(procedimientoDTO.getNota());
        // newProcedimientoDTO.setIdResponsable(procedimientoDTO.getIdResponsable());
        return new ResponseEntity<>(procedimientoService.update(newProcedimientoDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Guarda un nuevo procedimiento")
    @PostMapping("/")
    public ResponseEntity<ProcedimientoDTO> save(@RequestBody ProcedimientoDTO procedimiento) {
        return new ResponseEntity<>(procedimientoService.save(procedimiento), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un procedimiento por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        procedimientoService.delete(codigo);
    }

}
