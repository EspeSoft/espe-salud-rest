package com.espe.salud.app.api.v1.catalogo;

import static com.espe.salud.app.common.Constants.URI_API_V1_PAR;

import com.espe.salud.domain.entities.catalogo.Parentesco;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {URI_API_V1_PAR})
@Tag(name = "Gestiona el catálogo de parentescos")
public class ParentescoController {

    private final GenericCRUDService<Parentesco, ParentescoDTO> parentescoService;

    @Autowired
    public ParentescoController(
            @Qualifier("parentescoServiceImpl") GenericCRUDService<Parentesco, ParentescoDTO> parentescoService) {
        this.parentescoService = parentescoService;
    }

    @Operation(summary = "Retorna el listado de todos los parentescos en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ParentescoDTO>> getAll() {
        return new ResponseEntity<>( parentescoService.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna un parentesco por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<ParentescoDTO> retrieve(
            @Parameter(description = "El ID del parentesco", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(parentescoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo parentesco")
    public ResponseEntity<ParentescoDTO> save(@RequestBody ParentescoDTO parentescoDTO){
        return new ResponseEntity<>(parentescoService.saveOrUpdate(parentescoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un parentesco por su ID")
    public ResponseEntity<Boolean> deleteUser(
            @Parameter(required = true, description = "El ID del parentesco", example = "1")
            @PathVariable Long id) {
        return new ResponseEntity<>(parentescoService.delete(id), HttpStatus.OK);
    }

}
