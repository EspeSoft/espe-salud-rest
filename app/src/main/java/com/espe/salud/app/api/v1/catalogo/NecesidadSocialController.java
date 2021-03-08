package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.NecesidadSocial;
import com.espe.salud.dto.catalogo.NecesidadSocialDTO;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_NEC_SOC;

@RestController
@RequestMapping(value = {URI_API_V1_NEC_SOC})
@Tag(description = "Gestiona el catálogo de necesidades sociales", name = "Necesidades sociales")
public class NecesidadSocialController {

    private final GenericCRUDService<NecesidadSocial, NecesidadSocialDTO> service;

    @Autowired
    public NecesidadSocialController(
            @Qualifier("necesidadSocialServiceImpl") GenericCRUDService<NecesidadSocial, NecesidadSocialDTO> service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas necesidades sociales en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NecesidadSocialDTO>> getAll() {
        return new ResponseEntity<>(service.findAllOrderByNameASC(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna una necesidad social por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<NecesidadSocialDTO> retrieve(
            @Parameter(description = "El ID de la necesidad social", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nueva necesidad social")
    public ResponseEntity<NecesidadSocialDTO> save(@RequestBody NecesidadSocialDTO necesidadSocialDTO) {
        return new ResponseEntity<>(service.saveOrUpdate(necesidadSocialDTO), HttpStatus.CREATED);
    }

}
