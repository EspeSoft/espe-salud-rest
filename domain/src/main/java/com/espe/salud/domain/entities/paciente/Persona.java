package com.espe.salud.domain.entities.paciente;

import com.espe.salud.domain.enums.Sexo;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTPER", schema = "SALUD")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPER_CODIGO")
    private Long codigo;

    @Column(name = "MZSTPER_APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "MZSTPER_APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "MZSTPER_PRIMER_NOMBRE")
    private String primerNombre;

    @Column(name = "MZSTPER_SEGUNDO_NOMBRE")
    private String segundoNombre;

    @Column(name = "MZSTPER_CEDULA", unique = true)
    @NotEmpty
    @NaturalId
    private String cedula;

    @Column(name = "MZSTPER_FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "MZSTPER_SEXO")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "MZSTPER_ESTADO_CIVIL")
    private String estadoCivil;

    @Column(name = "MZSTPER_RELIGION")
    private String religion;

    @Column(name = "MZSTPER_GRUPO_SANGUINEO")
    @NotEmpty
    private String grupoSanguineo;

    @Column(name = "MZSTPER_INSTRUCCION")
    private String instruccion;

    @Column(name = "MZSTPER_PROFESION")
    private String profesion;

    @Column(name = "MZSTPER_VINCULADO_ESPE")
    @NotEmpty
    private String vinculadoEspe;

    @Column(name = "MZSTPER_PLURINACIONALIDAD")
    private String pueblos;

    @Column(name = "MZSTPER_ETNIA")
    private String etnia;

    @Column(name = "MZSTPER_SEGURO_SALUD")
    private String seguroSalud;

    @Column(name = "MZSTPER_ASOCIACION_AFILIADA")
    private String asociacionAfiliada;

    @NotNull
    @Column(name = "MZSTPER_PAIS_NACIMIENTO")
    private String paisNacimiento;

    @NotNull
    @Column(name = "MZSTPER_PROVINCIA_NACIMIENTO")
    private String provinciaNacimiento;

    @NotNull
    @Column(name = "MZSTPER_CANTON_NACIMIENTO")
    private String cantonNacimiento;

    @NotNull
    @Column(name = "MZSTPER_NACIONALIDAD")
    private String nacionalidad;

    @Column(name = "MZSTPER_NACIONALIDAD_2")
    private String nacionalidad2;

    @Embedded
    private Contacto contacto;

    @OneToOne(mappedBy = "persona")
    private Paciente paciente;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContactoEmergencia> contactosEmergencia;

    public void addToContactoEmergencia(List<ContactoEmergencia> contactos){
        if(!contactos.isEmpty()){
            for (ContactoEmergencia c: contactos) {
                c.setPersona(this);
            }
            this.contactosEmergencia = contactos;
        }
    }

    @CreatedDate
    @Column(name = "MZSTPER_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTPER_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTPER_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTPER_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = LocalDateTime.now();
    }

    public String getFullName() {
        String pn = this.primerNombre.toUpperCase();
        String sn = this.segundoNombre.toUpperCase();
        String ap = this.apellidoPaterno.toUpperCase();
        String am = this.apellidoMaterno.toUpperCase();
        return  pn + " " + sn + " " + ap + " " + am;
    }
}
