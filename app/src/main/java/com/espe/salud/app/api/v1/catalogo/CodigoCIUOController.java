package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.CodigoCIUODTO;
import com.espe.salud.service.catalogo.CodigoCIUOService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_COD_CIUO;

@RestController
@RequestMapping(value = {URI_API_V1_COD_CIUO})
@Tag(description = "Gestiona el catálogo de códigos CIUO", name = "Códigos CIUO")
public class CodigoCIUOController {
    private final CodigoCIUOService service;

    @Autowired
    public CodigoCIUOController(CodigoCIUOService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todos los codigo CIUO")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CodigoCIUODTO>> getAll() {
        return new ResponseEntity<>( service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    @Operation(summary = "Retorna un codigo CIUO por su ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    public ResponseEntity<CodigoCIUODTO> retrieve(
            @Parameter(description = "El codigo del CIUO", required = true, example = "01")
            @PathVariable("codigo") String codigo) {
        return service.findById(codigo)
                .map(codigoCIUO -> new ResponseEntity<>(codigoCIUO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Retorna los codigos ciuo que inicien con el texto")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/findByCodeOrDescription", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CodigoCIUODTO>> findByCodeOrDescriptio(
            @Parameter(required = true, description = "El Codigo CIUO o el nombre del OFICIO", example = "01") @RequestParam String query) {
        return new ResponseEntity<>( service.findByCodigoOrDescription(query), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna un nuevo código CIUO")
    public ResponseEntity<CodigoCIUODTO> save(@RequestBody CodigoCIUODTO codigoCIUODTO){
        return new ResponseEntity<>(service.save(codigoCIUODTO), HttpStatus.CREATED);
    }
}
