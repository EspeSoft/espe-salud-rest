package com.espe.salud.domain.entities.paciente;

import com.espe.salud.domain.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Column(name = "MZSTPER_CODIGO", updatable = false, nullable = false)
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

    @Column(name = "MZSTPER_ACEPTA_TRANSFUCION")
    @NotNull
    private boolean aceptaTransfucion;

    @Column(name = "MZSTPER_GRUPO_SANGUINEO")
    @NotEmpty
    private String grupoSanguineo;

    @Column(name = "MZSTPER_LATERALIDAD")
    @NotEmpty
    private String lateralidad;

    @Column(name = "MZSTPER_INSTRUCCION")
    private String instruccion;

    @Column(name = "MZSTPER_PRODESION")
    private String profesion;

    @Column(name = "MZSTPER_VINCULADO_ESPE")
    @NotEmpty
    private String vinculadoEspe;

    @Column(name = "MZSTPER_PUEBLOS")
    private String pueblos;

    @Column(name = "MZSTPER_GRUPO_CULTURAL")
    private String grupoCultural;

    @Column(name = "MZSTPER_SEGURO_SOCIAL")
    private String seguroSalud;

    @Column(name = "MZSTPER_ASOCIACION_AFILIADO")
    private String asociacionAfiliada;

    @Column(name = "MZSTPER_CIUO")
    @NotEmpty
    private String ciuo;

    @Column(name = "MZSTPER_CODIGO_CONSULTORIO")
    private Long idConsultorio;

    @NotNull
    @Column(name = "MZSTPER_CODIGO_PAIS_NACIMIENTO")
    private Long idPaisNacimiento;

    @NotNull
    @Column(name = "MZSTPER_CODIGO_PROVINCIA_NACIMIENTO")
    private Long idProvinciaNacimiento;

    @NotNull
    @Column(name = "MZSTPER_CODIGO_CANTON_NACIMIENTO")
    private Long idCantonNacimiento;

    @NotNull
    @Column(name = "MZSTPER_CODIGO_NACIONALIDAD")
    private Long idNacionalidad;

    @Column(name = "MZSTPER_CODIGO_NACIONALIDAD_2")
    private Long idNacionalidad2;

    @Embedded
    private Contacto contacto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_EST_PER", updatable = false, nullable = false)
    private Estudiante estudiante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_EMP_PER", updatable = false, nullable = false)
    private Empleado empleado;

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Paciente paciente;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ContactoEmergencia> contactosEmergencia;

//    public void addToContactoEmergencia(List<ContactoEmergencia> contactos){
//        if(!contactos.isEmpty()){
//            for (ContactoEmergencia contacto: contactos) {
//                contacto.setPersona(this);
//            }
//            this.contactosEmergencia = contactos;
//        }
//    }


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
}
