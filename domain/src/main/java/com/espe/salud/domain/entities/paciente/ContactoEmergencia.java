package com.espe.salud.domain.entities.paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

//    @JsonIgnore
//    @JoinColumn(name = "id_persona", referencedColumnName = "id")
//    @ManyToOne
//    private Persona persona;

}
