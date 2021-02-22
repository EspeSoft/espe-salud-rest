package com.espe.salud.dto.antecedente;

import com.espe.salud.dto.catalogo.TipoCertificadoDTO;
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

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private TipoCertificadoDTO tipoCertificadoDTO;

}
