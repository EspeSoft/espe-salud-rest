package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.dto.catalogo.NacionalidadPuebloDTO;
import com.espe.salud.service.catalogo.NacionalidadPuebloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_NAC_PUE;

@RestController
@RequestMapping(value = {URI_API_V1_NAC_PUE})
@Tag(description = "Gestiona el catálodo de nacionalidades y pueblos",  name = "Nacionalidades y pueblos")
public class NacionalidadPuebloController {
    private final NacionalidadPuebloService service;

    @Autowired
    public NacionalidadPuebloController(NacionalidadPuebloService service) {
        this.service = service;
    }

    @Operation(summary = "Retorna el listado de todas las nacionalidades y pueblos en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<NacionalidadPuebloDTO>> getAll() {
        return new ResponseEntity<>( service.findAllOrderByNombreASC(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Retorna una nacionalidad o pueblo por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
    })
    public ResponseEntity<NacionalidadPuebloDTO> retrieve(
            @Parameter(description = "El ID de la nacionaliad o pueblo", required = true, example = "1")
            @PathVariable("id") Long id) {
        return service.findById(id)
                .map(nacionalidadPuebloDTO -> new ResponseEntity<>(nacionalidadPuebloDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Operation(summary = "Guarda y retorna una nueva nacionaliad o pueblo")
    public ResponseEntity<NacionalidadPuebloDTO> save(@RequestBody NacionalidadPuebloDTO nacionalidadPuebloDTO){
        return new ResponseEntity<>(service.save(nacionalidadPuebloDTO), HttpStatus.CREATED);
    }

    @GetMapping("/grupo-cultural/{idGrupoCultural}")
    @Operation(summary = "Retorna el listado de nacionaliades y pueblos por el grupo cultural")
    public ResponseEntity<List<NacionalidadPuebloDTO>> findByGrupoCultural(
            @Parameter(description = "El ID del grupo cultural", required = true, example = "1")
            @PathVariable("idGrupoCultural") Long idGrupoCultural) {
        return new ResponseEntity<>(service.findByGrupoCulturalId(idGrupoCultural), HttpStatus.OK);
    }
}
