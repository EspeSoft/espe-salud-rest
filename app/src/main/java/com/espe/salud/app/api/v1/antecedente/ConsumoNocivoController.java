package com.espe.salud.app.api.v1.antecedente;

import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;
import com.espe.salud.service.antecedente.ConsumoNocivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_CON_NOC;

@RestController
@Tag(name = "Gestiona los Consumo Nocivo")
@RequestMapping(value = {URI_API_V1_CON_NOC})
public class ConsumoNocivoController {

    private final ConsumoNocivoService consumoNocivoService;

    @Autowired
    public ConsumoNocivoController(ConsumoNocivoService consumoNocivoService) {
        this.consumoNocivoService = consumoNocivoService;
    }

    @Operation(summary = "Retorna el listado de todos los consumos nocivos")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ConsumoNocivoDTO>> getAll() {
        return new ResponseEntity<>( consumoNocivoService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un consumo nocivo por su código")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConsumoNocivoDTO> findByCodigo(@RequestParam Long codigo) {
        return new ResponseEntity( consumoNocivoService.findByCodigo(codigo), HttpStatus.OK);
    }

    @Operation(summary = "Edita un consumo nocivo por su código")
    @PutMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConsumoNocivoDTO> update(@RequestBody ConsumoNocivoDTO consumoNocivoDTO, @RequestParam Long codigo) {
        Optional<ConsumoNocivoDTO> newConsumoNocivoDTOoptional = consumoNocivoService.findByCodigo(codigo);
        ConsumoNocivoDTO newConsumoNocivoDTO = newConsumoNocivoDTOoptional.get();
        newConsumoNocivoDTO.setNombreConsumoNocivo(consumoNocivoDTO.getNombreConsumoNocivo());
        newConsumoNocivoDTO.setConsume(consumoNocivoDTO.getConsume());
        newConsumoNocivoDTO.setTiempoConsumoMes(consumoNocivoDTO.getTiempoConsumoMes());
        newConsumoNocivoDTO.setFrecuenciaConsumo(consumoNocivoDTO.getFrecuenciaConsumo());
        newConsumoNocivoDTO.setCantidadConsumo(consumoNocivoDTO.getCantidadConsumo());
        newConsumoNocivoDTO.setExConsumidor(consumoNocivoDTO.getExConsumidor());
        newConsumoNocivoDTO.setTiempoAbstinenciaMes(consumoNocivoDTO.getTiempoAbstinenciaMes());
        newConsumoNocivoDTO.setObservacion(consumoNocivoDTO.getObservacion());

        return new ResponseEntity<>(consumoNocivoService.update(newConsumoNocivoDTO), HttpStatus.CREATED) ;
    }

    @Operation(summary = "Guarda un nuevo consumo nocivo")
    @PostMapping("/")
    public ResponseEntity<ConsumoNocivoDTO> save(@RequestBody ConsumoNocivoDTO consumoNocivo){
        return new ResponseEntity<>(consumoNocivoService.save(consumoNocivo), HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un consumo nocivo por su código")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo) {
        consumoNocivoService.delete(codigo);
    }


}
