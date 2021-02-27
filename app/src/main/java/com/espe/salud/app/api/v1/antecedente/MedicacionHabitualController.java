package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.MedicacionHabitalDTO;
import com.espe.salud.service.antecedente.MedicacionHabitualService;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_MED_HABITUAL;

@RestController
@Tag(description = "Gestiona medicamentos habituales", name = "Medicaciones habituales")
@RequestMapping(value = {URI_API_V1_MED_HABITUAL})
public class MedicacionHabitualController {

    private final MedicacionHabitualService service;

    @Autowired
    public MedicacionHabitualController(MedicacionHabitualService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los medicamentos habituales")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MedicacionHabitalDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un medicamento habitual por su ID")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MedicacionHabitalDTO> getById(
            @Parameter(description = "El ID del medicamento habitual",required = true,example = "1")
            @PathVariable("id") Long id){
        return new ResponseEntity(service.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Edita un medicamento habitual por su codigo")
    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MedicacionHabitalDTO> update(
            @RequestBody MedicacionHabitalDTO dto, @PathVariable Long id){

        Optional<MedicacionHabitalDTO> newMedicamentoHabitualDTOOptinal=service.findById(id);
        MedicacionHabitalDTO newMedicacionHabitualDTO=newMedicamentoHabitualDTOOptinal.get();
        newMedicacionHabitualDTO.setCantidad(dto.getCantidad());
        newMedicacionHabitualDTO.setDescripcionMedicamento(dto.getDescripcionMedicamento());
        newMedicacionHabitualDTO.setFrecuencia(dto.getFrecuencia());
        newMedicacionHabitualDTO.setObservacion(dto.getObservacion());
        newMedicacionHabitualDTO.setIdAntecedentePersonal(dto.getIdAntecedentePersonal());
        return new ResponseEntity<>(service.update(newMedicacionHabitualDTO),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Guardar un nuevo medicamento habitual")
    @PostMapping("/")
    public ResponseEntity<MedicacionHabitalDTO> save(@RequestBody MedicacionHabitalDTO dto){
        return new ResponseEntity<>(service.save(dto),HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un medicamento habitual por su codigo")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        service.deleteById(codigo);
    }
}
