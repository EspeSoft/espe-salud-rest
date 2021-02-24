package com.espe.salud.app.api.v1.certificado;

import com.espe.salud.dto.certificado.CertificadoDTO;
import com.espe.salud.service.certificado.CertificadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.espe.salud.app.common.Constants.URI_API_V1_CER;

@RestController
@Tag(name = "Gestiona Certificados")
@RequestMapping(value = {URI_API_V1_CER})
public class CertificadoController {
    
    private final CertificadoService service;

    public CertificadoController(CertificadoService service) {
        this.service = service;
    }
    @Operation(summary = "Retorna el listado de todos los Certificados")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CertificadoDTO>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna un certificadp por su codigo")
    @GetMapping(value = "/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CertificadoDTO> getById(@Parameter(description = "El codigo del certificado",required = true,example = "1") @PathVariable("codigo") Long id){
        return new ResponseEntity(service.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Retorna los certificados de un paciente")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping(value = "/paciente", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CertificadoDTO>> findByPaciente(
            @Parameter(required = true, description = "El ID del paciente", example = "1") @RequestParam Long idPaciente) {
        return new ResponseEntity<>( service.findByPaciente(idPaciente), HttpStatus.OK);
    }

    @Operation(summary = "Edita un certificado por su codigo")
    @PutMapping(value = "/{codigo}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CertificadoDTO> update(@Valid @RequestBody CertificadoDTO dto, @RequestParam Long codigo){

        Optional<CertificadoDTO> optional=service.findById(codigo);
        if(optional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            CertificadoDTO certificadoDTO= optional.get();
            certificadoDTO.setDiasReposo(dto.getDiasReposo());
            certificadoDTO.setDiagnosticoCie10(dto.getDiagnosticoCie10());
            certificadoDTO.setEquivalenteHorasLaborables(dto.getEquivalenteHorasLaborables());
            certificadoDTO.setFechaRegistro(dto.getFechaRegistro());
            certificadoDTO.setInstitucionEmite(dto.getInstitucionEmite());
            certificadoDTO.setFechaDesde(dto.getFechaDesde());
            certificadoDTO.setFechaHasta(dto.getFechaHasta());
            certificadoDTO.setIdCertificado(dto.getIdCertificado());
            certificadoDTO.setIdEvolucion(dto.getIdEvolucion());
            certificadoDTO.setEvolucionDTO(dto.getEvolucionDTO());
            certificadoDTO.setTipoCertificadoDTO(dto.getTipoCertificadoDTO());

            return new ResponseEntity<>(service.update(certificadoDTO),HttpStatus.ACCEPTED);
        }

    }

    @Operation(summary = "Guardar un nuevo certificado")
    @PostMapping("/")
    public ResponseEntity<CertificadoDTO> save(@RequestBody CertificadoDTO dto){
        return new ResponseEntity<>(service.save(dto),HttpStatus.CREATED);
    }

    @Operation(summary = "Elimina un certificado por su codigo")
    @DeleteMapping("/{codigo}")
    public void delete(@PathVariable Long codigo){
        service.deleteById(codigo);
    }
}
