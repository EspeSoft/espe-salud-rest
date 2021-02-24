package com.espe.salud.app.api.v1.ocupacional;

import com.espe.salud.dto.ocupacional.AntecedenteEnfermedadProfesionalDTO;
import com.espe.salud.service.ocupacional.AntecedenteEnfermedadProfesionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_ACC_TRA;
import static com.espe.salud.app.common.Constants.URI_API_V1_ANT_ENF_PRO;

@RestController
@Tag(description = "Gestiona los antecedentes de enfermedades profesionales", name = "Antecedentes de Enfermedades Profesionales")
@RequestMapping(value = URI_API_V1_ANT_ENF_PRO)
public class AntecedenteEnfermedadProfesionalController {
    private final AntecedenteEnfermedadProfesionalService serviceAntecedente;

    @Autowired
    public AntecedenteEnfermedadProfesionalController(
            @Qualifier("antecedenteEnfermedadProfesionalServiceImpl") AntecedenteEnfermedadProfesionalService serviceAntecedente
    ) {
        this.serviceAntecedente = serviceAntecedente;
    }

    @Operation(summary = "Retorna el listado de todos los antecedentes")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AntecedenteEnfermedadProfesionalDTO>> getAll() {
        return new ResponseEntity<>( serviceAntecedente.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un antecedente por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteEnfermedadProfesionalDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity(serviceAntecedente.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un antecedente por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AntecedenteEnfermedadProfesionalDTO> update(@RequestBody AntecedenteEnfermedadProfesionalDTO antecedenteDTO, @RequestParam Long codigo) {
        Optional<AntecedenteEnfermedadProfesionalDTO> newAntecedenteEnfermedadProfesionalDTOoptional = serviceAntecedente.findByCodigo(codigo);
        AntecedenteEnfermedadProfesionalDTO newAntecedenteEnfermedadProfesionalDTO = newAntecedenteEnfermedadProfesionalDTOoptional.get();
        newAntecedenteEnfermedadProfesionalDTO.setLugarAtencion(antecedenteDTO.getLugarAtencion());
        newAntecedenteEnfermedadProfesionalDTO.setEmpresa(antecedenteDTO.getEmpresa());
        newAntecedenteEnfermedadProfesionalDTO.setFecha(antecedenteDTO.getFecha());
        newAntecedenteEnfermedadProfesionalDTO.setHorasReposo(antecedenteDTO.getHorasReposo());
        newAntecedenteEnfermedadProfesionalDTO.setObservaciones(antecedenteDTO.getObservaciones());
        newAntecedenteEnfermedadProfesionalDTO.setRecibioAtencion(antecedenteDTO.getRecibioAtencion()                );
        newAntecedenteEnfermedadProfesionalDTO.setRiesgoImplicado(antecedenteDTO.getRiesgoImplicado());
        newAntecedenteEnfermedadProfesionalDTO.setSecuelas(antecedenteDTO.getSecuelas());
        return new ResponseEntity<>(serviceAntecedente.update(newAntecedenteEnfermedadProfesionalDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo antecedente")
    @PostMapping("/")
    public ResponseEntity<AntecedenteEnfermedadProfesionalDTO> save(@RequestBody AntecedenteEnfermedadProfesionalDTO antecedente){
        return new ResponseEntity<>(serviceAntecedente.save(antecedente), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un antecedente por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        serviceAntecedente.delete(codigo);
    }
}
