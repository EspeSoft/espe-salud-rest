package com.espe.salud.domain.entities.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "MZSTCONEME", schema = "SALUD")
public class ContactoEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCODEME_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCONEME_NOMBRE_CONTACTO")
    private String nombreContacto;

    @Column(name = "MZSTCONEME_DIRECCION")
    private String direccion;

    @Column(name = "MZSTCONEME_TELEFONO_CELULAR")
    @NotEmpty
    private String telefonoCelular;

    @Column(name = "MZSTCONEME_TELEFONO_CONVENCIONAL")
    private String telefonoConvencional;

    @NotEmpty
    @Column(name = "MZSTCONEME_PARENTESCO")
    private String parentesco;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PER_CONEME", insertable = false, updatable = false)
    private Persona persona;

    @CreatedDate
    @Column(name = "MZSTCONEME_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTCONEME_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTCONEME_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTCONEME_USUARIO_MODIFICACION")
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
