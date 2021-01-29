package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedadPersonal;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.dto.catalogo.TipoEnfermedadPersonalDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIPENFPER;

@RestController
@RequestMapping(value = {URI_API_V1_TIPENFPER})
@Tag(name = "Gestiona el cátalogo de tipos de enfermedades personales")
public class TipoEnfermedadPersonalController {

    private final GenericCRUDService<TipoEnfermedadPersonal, TipoEnfermedadPersonalDTO> tipoenfermedadpersonalService;

    @Autowired
    public TipoEnfermedadPersonalController(
            @Qualifier("tipoEnfermedadPersonalServiceImpl") GenericCRUDService<TipoEnfermedadPersonal, TipoEnfermedadPersonalDTO> tipoenfermedadpersonalService) {
        this.tipoenfermedadpersonalService = tipoenfermedadpersonalService;
    }


    @Operation(summary = "Retorna el listado de todos los tipos de enfermedades personales")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoEnfermedadPersonalDTO>> getAll() {
        TipoEnfermedadPersonalDTO tipoEnfermedadPersonalDTO = new TipoEnfermedadPersonalDTO();
        return new ResponseEntity<>( tipoenfermedadpersonalService.findAll(tipoEnfermedadPersonalDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo tipo de enfermedad personal")
    public ResponseEntity<TipoEnfermedadPersonalDTO> save(@RequestBody TipoEnfermedadPersonalDTO tipoEnfermedadPersonalDTO){
        return new ResponseEntity<>(tipoenfermedadpersonalService.saveOrUpdate(tipoEnfermedadPersonalDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un tipo de enfermedad personal por su ID")
    public ResponseEntity<Boolean> deleteUser(
            @Parameter(required = true, description = "El ID del tipo de enfermedad personal", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(tipoenfermedadpersonalService.delete(id), HttpStatus.OK);
    }


}
