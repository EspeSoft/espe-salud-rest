package com.espe.salud.domain.entities.evolucion;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTDIA", schema = "SALUD")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTDIA_CODIGO")
    private Long codigo;

    @Column(name = "MZSTDIA_CODIGO_CIE")
    @NotEmpty
    private String codigoCIE; // to do relacionar

    @Column(name = "MZSTDIA_PREVENCION")
    @NotEmpty
    private String prevencion;

    @Column(name = "MZSTDIA_PMORBILIDAD")
    @NotEmpty
    private String morbilidad;


    @Column(name = "MZSTDIA_CONDICION__DIAGNOSTICO")
    @NotEmpty
    private String condicionDiagnostico;

    @CreatedBy
    @Column(name = "MZSTDIA_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTDIA_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTDIA_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTDIA_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }




}
