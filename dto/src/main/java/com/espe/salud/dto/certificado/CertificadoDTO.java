package com.espe.salud.dto.certificado;

import com.espe.salud.dto.catalogo.TipoCertificadoDTO;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class CertificadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private LocalDateTime fechaDesde;
    private LocalDateTime fechaHasta;
    private String institucionEmite;
    private Integer diasReposo;
    private Integer equivalenteHorasLaborables;
    private String diagnosticoCie10;
    private LocalDateTime fechaRegistro;

    @NotNull
    private Long idCertificado;

    private String idEvolucion;
    private TipoCertificadoDTO tipoCertificadoDTO;
    private EvolucionDTO evolucionDTO;

}
