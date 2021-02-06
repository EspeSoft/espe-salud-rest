package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.Asociacion;
import com.espe.salud.dto.catalogo.AsociacionDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_ASO;

@RestController
@RequestMapping(value = {URI_API_V1_ASO})
@Tag(name = "Gestiona el cátalodo de asociacion")
public class AsociacionController {

    private final GenericCRUDService<Asociacion, AsociacionDTO> asociacionService;

    @Autowired
    public AsociacionController(
            @Qualifier("asociacionServiceImpl") GenericCRUDService<Asociacion, AsociacionDTO> asociacionService) {
        this.asociacionService = asociacionService;
    }

    @Operation(summary = "Retorna el listado de todas las asociacianes en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AsociacionDTO>> getAll() {
        return new ResponseEntity<>( asociacionService.findAllOrderByNameASC(), HttpStatus.OK);
    }
}
