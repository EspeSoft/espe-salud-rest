package com.espe.salud.app.api.v1.paciente;

import com.espe.salud.dto.paciente.RecordLaboralDTO;
import com.espe.salud.service.paciente.RecordLaboralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_REC_LAB;

@RestController
@Tag(name = "Gestiona los Record Laboral  de paciente")
@RequestMapping(value = URI_API_V1_REC_LAB)
public class RecordLaboralController {
    private final RecordLaboralService recordLaboralService;

    @Autowired
    public RecordLaboralController(RecordLaboralService recordLaboralService) {
        this.recordLaboralService = recordLaboralService;
    }

    @Operation(summary = "Retorna el listado de todos los records labirales")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RecordLaboralDTO>> getAll() {
        return new ResponseEntity<>( recordLaboralService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un reord laboral  por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecordLaboralDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity( recordLaboralService.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un record laboral por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RecordLaboralDTO> update(@RequestBody RecordLaboralDTO recordLaboralDTO, @RequestParam Long codigo) {
        Optional<RecordLaboralDTO> newRecordLaboralDTOoptional = recordLaboralService.findByCodigo(codigo);
        RecordLaboralDTO newRecordLaboralDTO = newRecordLaboralDTOoptional.get();
        newRecordLaboralDTO.setFechaRegistro(recordLaboralDTO.getFechaRegistro());
        newRecordLaboralDTO.setCausa(recordLaboralDTO.getCausa());
        newRecordLaboralDTO.setEdad(recordLaboralDTO.getEdad());
        newRecordLaboralDTO.setFechaReingreso(recordLaboralDTO.getFechaReingreso());
        newRecordLaboralDTO.setFechaSalidad(recordLaboralDTO.getFechaSalidad());
        newRecordLaboralDTO.setDiasEntreSalidoIngreso(recordLaboralDTO.getDiasEntreSalidoIngreso());
        return new ResponseEntity<>(recordLaboralService.update(newRecordLaboralDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo record laboral")
    @PostMapping("/")
    public ResponseEntity<RecordLaboralDTO> save(@RequestBody RecordLaboralDTO paciente){
        return new ResponseEntity<>(recordLaboralService.save(paciente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un record laboral por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        recordLaboralService.delete(codigo);
    }
}
