package com.espe.salud.domain.entities.ocupacional;

import com.espe.salud.domain.entities.enfermeria.NotaEnfermeria;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.usuario.Usuario;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "MZSTANTLAB", schema = "SALUD")
public class AntecedenteLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTANTLAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "FK_PAC_ANTLAB")
    private Long idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PAC_ANTLAB", insertable = false, updatable = false)
    private Paciente paciente;

    @Column(name = "FK_USU_ANTLAB")
    private Long idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_USU_ANTLAB", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "antecedenteLaboral", cascade = CascadeType.ALL)
    private List<AntecedenteIncidenteTrabajo> antecedentesIncidenteTrabajos;

    @OneToMany(mappedBy = "antecedenteLaboral", cascade = CascadeType.ALL)
    private List<AntecedenteAccidenteTrabajo> antecedentseAccidenteTrabajos;

    @OneToMany(mappedBy = "antecedenteLaboral", cascade = CascadeType.ALL)
    private List<AntecedenteEnfermedadProfesional> antecedentesEnfermedadProfesionales;

    @OneToMany(mappedBy = "antecedenteLaboral", cascade = CascadeType.ALL)
    private List<FactorRiesgoPuestoActual> factores;

    @OneToMany(mappedBy = "antecedenteLaboral", cascade = CascadeType.ALL)
    private List<ActividadExtralaboral> actividadesExtralaborales;

    @OneToMany(mappedBy = "antecedenteLaboral", cascade = CascadeType.ALL)
    private List<AntecedenteEmpleoAnterior> antecedentesEmpleoAnteriores;

    @CreatedDate
    @Column(name = "MZSTANTLAB_FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTLAB_FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @CreatedBy
    @Column(name = "MZSTANTLAB_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTLAB_USUARIO_MODIFICACION")
    private String usuarioModificacion;
}
