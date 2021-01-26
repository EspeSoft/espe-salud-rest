package com.espe.salud.domain.entities.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MZSTCON", schema = "SALUD")
public class Contacto {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCON_CODIGO")
    private Long codigo;

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

    @Column(name = "MZSTCON_NUM_CON")
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

    @Column(name = "MZSTCON_CODIDO_CANTON_RESIDENCIA")
    private Long idCantonResidencia;

    @Column(name = "MZSTCON_CODIGO_PROVINCIA_RESIDENCIA")
    private Long idProvinciaResidencia;

    @Column(name = "MZSTCON_USUARIO_CREACION")
    private String usuarioCreacion;

    @Column(name = "MZSTCON_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @Column(name = "MZSTCON_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "MZSTCON_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }

//    @OneToOne(mappedBy = "contacto")
//    @JsonIgnore
//    private Persona persona;
}
