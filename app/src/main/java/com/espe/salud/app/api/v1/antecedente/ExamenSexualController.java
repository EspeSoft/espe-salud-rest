package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.ExamenSexualDTO;
import com.espe.salud.service.antecedente.ExamenSexualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_EXASEX;

@RestController
@Tag(name = "Gestiona Exámenes Sexuales")
@RequestMapping(value = {URI_API_V1_EXASEX})
public class ExamenSexualController {

    private final ExamenSexualService service;

    @Autowired
    public ExamenSexualController(ExamenSexualService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los Exámenes Sexuales")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ExamenSexualDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un examen sexual por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExamenSexualDTO> getById(@Parameter(description = "El codigo del examen sexual", required = true, example = "1") @PathVariable("codigo") Long id) {
        return new ResponseEntity(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edita un examen sexual por su codigo")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ExamenSexualDTO> update(@RequestBody ExamenSexualDTO dto, @RequestParam Long codigo) {
        Optional<ExamenSexualDTO> newExamenSexualDTOoptional = service.findById(codigo);
        ExamenSexualDTO newExamenSexualDTO = newExamenSexualDTOoptional.get();
        newExamenSexualDTO.setFecha(dto.getFecha());
        newExamenSexualDTO.setNombreExamen(dto.getNombreExamen());
        newExamenSexualDTO.setRealizado(dto.getRealizado());
        newExamenSexualDTO.setTiempoAnios(dto.getTiempoAnios());
        newExamenSexualDTO.setResuldato(dto.getResuldato());
        return new ResponseEntity<>(service.update(newExamenSexualDTO), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar un nuevo examen sexual")
    @PostMapping("/")
    public ResponseEntity<ExamenSexualDTO> save(@RequestBody ExamenSexualDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un examen sexual por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        service.deleteById(codigo);
    }
}

