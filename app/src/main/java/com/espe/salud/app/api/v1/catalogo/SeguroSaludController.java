package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.SeguroSalud;
import com.espe.salud.dto.catalogo.SeguroSaludDTO;
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

import static com.espe.salud.app.common.Constants.URI_API_V1_SEGSAL;

@RestController
@RequestMapping(value = {URI_API_V1_SEGSAL})
@Tag(name = "Gestiona el cátalodo de seguro salud")
public class SeguroSaludController {

    private final GenericCRUDService<SeguroSalud, SeguroSaludDTO> segurosaludService;

    @Autowired
    public SeguroSaludController(
            @Qualifier("seguroSaludServiceImpl") GenericCRUDService<SeguroSalud, SeguroSaludDTO> segurosaludService) {
        this.segurosaludService = segurosaludService;
    }


    @Operation(summary = "Retorna el listado de todos los seguros salud")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SeguroSaludDTO>> getAll() {
        SeguroSaludDTO segurosaludDTO = new SeguroSaludDTO();
        return new ResponseEntity<>( segurosaludService.findAll(segurosaludDTO), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo seguro salud")
    public ResponseEntity<SeguroSaludDTO> save(@RequestBody SeguroSaludDTO segurosaludDTO){
        return new ResponseEntity<>(segurosaludService.saveOrUpdate(segurosaludDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un seguro salud por su ID")
    public ResponseEntity<Boolean> deleteUser(
            @Parameter(required = true, description = "El ID del seguro salud", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(segurosaludService.delete(id), HttpStatus.OK);
    }

}
