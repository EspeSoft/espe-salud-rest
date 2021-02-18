package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MZSTANTQUI", schema = "SALUD")
public class AntecedenteQuirurgico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTANTQUI_CODIGO")
    private Long codigo;

    @Lob
    @Column(name = "MZSTANTQUI_DIAGNOSTICO_PRE_QUIRURGICO")
    private String diagnosticoPreQuirurgico;

    @Lob
    @Column(name = "MZSTANTQUI_PROCEDIMIENTO_QUIRURGICO")
    private String procedimientoQuirurgico;

    @Column(name = "MZSTANTQUI_FECHA_PROCEDIMIENTO")
    private LocalDate fechaProcedimiento;

    @Lob
    @Column(name = "MZSTANTQUI_SECUELAS")
    private String secuelas;

    @Column(name = "FK_MZSTANTQUI_ANTECEDENTE_PERSONAL")
    private Long idAntecedentePersonal;

    @ManyToOne
    @JoinColumn(name = "FK_MZSTANTQUI_ANTECEDENTE_PERSONAL",insertable = false,updatable = false)
    private AntecedentePersonal antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTANTQUI_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTQUI_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTANTQUI_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTQUI_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}