package com.espe.salud.domain.entities.antecedente;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MZSTANTPATPER", schema = "SALUD")
public class AntecedentePatologicoPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTANTPATPER_CODIGO")
    private Long codigo;

    @Lob
    @Column(name = "MZSTANTPATPER_TIPO_ENFERMEDAD_PERSONAL")
    private String tipoEnfermedadPersonal;

    @Column(name = "MZSTANTPATPER_FECHA_DIAGNOSTICO")
    private LocalDate fechaDiagnostico;

    @Lob
    @Column(name = "MZSTANTPATPER_TOMA_MEDICACION")
    private String tomaMedicacion;

    @Lob
    @Column(name = "MZSTANTPATPER_DIAGNOSTICO")
    private String diagnostico;

    @Lob
    @Column(name = "MZSTANTPATPER_ANTECEDENTE_PERSONAL")
    private String antecedentePersonal;

    @CreatedBy
    @Column(name = "MZSTANTPATPER_USUARIO_CREACION")
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "MZSTANTPATPER_USUARIO_MODIFICACION")
    private String usuarioModificacion;

    @CreatedDate
    @Column(name = "MZSTANTPATPER_FECHA_CREACION")
    private LocalDate fechaCreacion;

    @LastModifiedDate
    @Column(name = "MZSTANTPATPER_FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}
