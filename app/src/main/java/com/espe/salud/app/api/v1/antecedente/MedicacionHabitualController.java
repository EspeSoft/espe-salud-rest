package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.MedicacionHabitualDTO;
import com.espe.salud.service.antecedente.MedicacionHabitualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_MED_HABITUAL;

@RestController
@Tag(description = "Gestiona los medicamentos habituales de un paciente", name = "Medicaciones habituales")
@RequestMapping(value = {URI_API_V1_MED_HABITUAL})
public class MedicacionHabitualController {

    private final MedicacionHabitualService service;

    @Autowired
    public MedicacionHabitualController(MedicacionHabitualService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las medicaciones habituales de un paciente")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MedicacionHabitualDTO>> findByPaciente(
            @Parameter(description = "El ID del paciente", required = true, example = "1")
            @RequestParam Long idPaciente) {
        return new ResponseEntity<>(service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Retorna una medicación habitual por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MedicacionHabitualDTO> getById(
            @Parameter(description = "ID medicación habitual", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(medicacion -> new ResponseEntity<>(medicacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Edita una medicación habitual por su ID")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MedicacionHabitualDTO> update(
            @Valid @RequestBody MedicacionHabitualDTO dto, @PathVariable("id") Long id) {
        Optional<MedicacionHabitualDTO> optional = service.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
        }
    }


    @Operation(summary = "Guardar una nueva medicación habitual")
    @PostMapping("/")
    public ResponseEntity<MedicacionHabitualDTO> save(@Valid @RequestBody MedicacionHabitualDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente patológico familiar por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(
            @Parameter(description = "ID del antecedente patológico familiar", required = true, example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
