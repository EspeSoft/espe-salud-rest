package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.DiscapacidadDTO;
import com.espe.salud.service.antecedente.DiscapacidadService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_DISCAPACIDAD;

@RestController
@Tag(description = "Gestiona las discapacidad de un paciente", name = "Discapacidades")
@RequestMapping(value = {URI_API_V1_DISCAPACIDAD})
public class DiscapacidadController {

    private final DiscapacidadService service;

    @Autowired
    public DiscapacidadController(DiscapacidadService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las dicapacidades")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DiscapacidadDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna una discapacidad por su codigo")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiscapacidadDTO> getById(@Parameter(description = "El codigo de la discapacidad", required = true, example = "1") @PathVariable("codigo") Long id) {
        return new ResponseEntity(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Edita una discapacidad por su codigo")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiscapacidadDTO> update(@RequestBody DiscapacidadDTO dto, @RequestParam Long codigo) {

        Optional<DiscapacidadDTO> newDiscapacidadDTOoptional = service.findById(codigo);
        DiscapacidadDTO newDiscapacidadDTO = newDiscapacidadDTOoptional.get();
        newDiscapacidadDTO.setGradoDiscapacidad(dto.getGradoDiscapacidad());
        newDiscapacidadDTO.setColaboradorDiscapacidad(dto.getColaboradorDiscapacidad());
        newDiscapacidadDTO.setTipoDiscapacidad(dto.getTipoDiscapacidad());
        newDiscapacidadDTO.setPorcentajeDiscapacidad(dto.getPorcentajeDiscapacidad());
        newDiscapacidadDTO.setDiagnosticoRelacionDiscapacidad(dto.getDiagnosticoRelacionDiscapacidad());
        newDiscapacidadDTO.setEsColaboradorSustituto(dto.getEsColaboradorSustituto());
        return new ResponseEntity<>(service.update(newDiscapacidadDTO), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar una nueva discapacidad")
    @PostMapping("/")
    public ResponseEntity<DiscapacidadDTO> save(@RequestBody DiscapacidadDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina una discapacidad por su codigo")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        service.deleteById(codigo);
    }
}
