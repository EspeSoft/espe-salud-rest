package com.espe.salud.domain.entities.odontologia;

import com.espe.salud.domain.entities.paciente.Paciente;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTHISCLIODO", schema = "SALUD")
public class HistoriaClinicaOdontologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTHISCLIODO_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @NotNull
    @Column(name = "MZSTHISCLIODO_FECHA_APERTURA")
    private LocalDateTime fechaApertura;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @NotNull
    @Column(name = "MZSTHISCLIODO_FECHA_CONTROL")
    private LocalDateTime fechaControl;

    @Size(max = 50)
    @NotEmpty
    @Column(name = "MZSTHISCLIODO_PROFESIONAL")
    private String profesional;

    @Size(max = 20)
    @NotEmpty
    @Column(name = "MZSTHISCLIODO_CODIGOPROFESIONAL")
    private String codigoProfesional;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PAC_HISCLIODO", updatable = false, insertable = false)
    private Paciente paciente;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EnfermedadProblemaActual> enfermedadesProblemaActual;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExamenSistemaEstomatognatico> examenesSistemaEstogmatognatico;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<IndicadorSaludBucal> indicadoresSaludBucal;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleOdontograma> detallesOdontograma;

}
