package com.espe.salud.domain.entities.paciente;

import com.espe.salud.domain.enums.Sexo;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
    @Size(max = 15)
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
    @Size(max = 20)
    private String religion;

    @Column(name = "MZSTPER_ACEPTA_TRANSFUCION")
    @NotNull
    private boolean aceptaTransfucion;

    @Column(name = "MZSTPER_GRUPO_SANGUINEO")
    @Size(max = 4)
    @NotEmpty
    private String grupoSanguineo;

    @Column(name = "MZSTPER_LATERALIDAD")
    @Size(max = 20)
    @NotEmpty
    private String lateralidad;

    @Column(name = "MZSTPER_INSTRUCCION")
    @Size(max = 50)
    private String instruccion;

    @Column(name = "MZSTPER_PRODESION")
    @Size(max = 50)
    private String profesion;

    @Column(name = "MZSTPER_VINCULADO_ESPE")
    @Size(max = 30)
    @NotEmpty
    private String vinculadoEspe;

    @Column(name = "MZSTPER_PUEBLOS")
    @Size(max = 20)
    private String pueblos;

    @Column(name = "MZSTPER_GRUPO_CULTURAL")
    @Size(max = 20)
    private String grupoCultural;

    @Column(name = "MZSTPER_SEGURO_SOCIAL")
    private String seguroSalud;

    @Column(name = "MZSTPER_ASOCIACION_AFILIADO")
    private String asociacionAfiliada;

    @Column(name = "MZSTPER_CIUO")
    @Size(max = 50)
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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_contacto", referencedColumnName = "id")
//    private Contacto contacto;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
//    private Estudiante estudiante;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
//    private Empleado empleado;

//    @OneToOne(mappedBy = "persona")
//    @JsonIgnore
//    private Paciente paciente;
//
//    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ContactoEmergencia> contactosEmergencia;
//
//    public void addToContactoEmergencia(List<ContactoEmergencia> contactos){
//        if(!contactos.isEmpty()){
//            for (ContactoEmergencia contacto: contactos) {
//                contacto.setPersona(this);
//            }
//            this.contactosEmergencia = contactos;
//        }
//    }
}
