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
@Table(name = "MZSTCON_EME", schema = "SALUD")
public class ContactoEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCOD_EME_CODIGO")
    private Long codigo;

    @Column(name = "MZSTCON_EME_NOMBRE_CONTACTO")
    @Size(max = 50)
    private String nombreContacto;

    @Column(name = "MZSTCON_EME_DIRECCION")
    @Size(max = 50)
    private String direccion;

    @Column(name = "MZSTCON_EME_TELEFONO_CELULAR")
    @Size(max = 20)
    @NotEmpty
    private String telefonoCelular;

    @Column(name = "MZSTCON_EME_TELEFONO_CONVENCIONAL")
    @Size(max = 20)
    private String telefonoConvencional;

    @NotEmpty
    @Column(name = "MZSTCON_EME_PARENTESCO")
    private String parentesco;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PER_CON_EME", insertable = false, updatable = false)
    private Persona persona;

    @CreatedDate
    @Column(name = "MZSTCON_EME_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTCON_EME_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTCON_EME_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTCON_EME_USUARIO_MODIFICACION")
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
