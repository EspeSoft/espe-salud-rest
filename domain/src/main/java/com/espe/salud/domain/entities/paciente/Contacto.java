package com.espe.salud.domain.entities.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Embeddable
public class Contacto {

    @Column(name = "MZSTCON_CALL_PRI")
    @NotEmpty
    private String callePrincipal;

    @Column(name = "MZSTCON_CALL_SEC")
    private String calleSecundaria;

    @Column(name = "MZSTCON_ZON_GEO")
    private String zonaGeografica;

    @Column(name = "MZSTCON_NUM_CEL")
    @NotEmpty
    private String numeroCelular;

    @Column(name = "MZSTCON_NUM_CO-N")
    private String numeroConvencional;

    @Column(name = "MZSTCON_EXT")
    private String extension;

    @Column(name = "MZSTCON_COR_PER")
    @Email
    @NotEmpty
    private String correoPersonal;

    @Column(name = "MZSTCON_CORREO_INSTITUCIONAL")
    @Email
    private String correoInstitucional;

    @Column(name = "MZSTCON_PARROQUIA")
    private String parroquia;

    @Column(name = "MZSTCON_BARRIO")
    private String barrio;
//  TO DO
//    @Column(name = "MZSTCON_CODIDO_CANTON_RESIDENCIA")
//    private Long idCantonResidencia;
//
//    @Column(name = "MZSTCON_CODIGO_PROVINCIA_RESIDENCIA")
//    private Long idProvinciaResidencia;


    @CreatedDate
    @Column(name = "MZSTCON_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTCON_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTCON_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTCON_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }
}
