package com.espe.salud.app.api.v1.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoCertificado;
import com.espe.salud.dto.catalogo.TipoCertificadoDTO;
import com.espe.salud.service.GenericCRUDService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.espe.salud.app.common.Constants.URI_API_V1_TIPCER;

@RestController
@RequestMapping(value = {URI_API_V1_TIPCER})
@Tag(name = "Gestiona el cátalodo de Tipo Certificado")
public class TipoCertificadoController {

    private final GenericCRUDService<TipoCertificado, TipoCertificadoDTO> tipocertificadoService;

    @Autowired
    public TipoCertificadoController(
            @Qualifier("tipoCertificadoServiceImpl") GenericCRUDService<TipoCertificado, TipoCertificadoDTO> tipocertificadoService) {
        this.tipocertificadoService = tipocertificadoService;
    }

    @Operation(summary = "Retorna el listado de todos los tipos de certificado en orden alfabético")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TipoCertificadoDTO>> getAll() {
        return new ResponseEntity<>( tipocertificadoService.findAllOrderByNameASC(), HttpStatus.OK);
    }

}
