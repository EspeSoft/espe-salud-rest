package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.antecedente.ExamenSexual;
import com.espe.salud.domain.enums.SexoTipoPlanificacionFamiliar;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPEXASEX", schema = "SALUD")
public class TipoExamenSexual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPEXASEX_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPEXASEX_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCTIPEXASEX_SEXO")
    @Enumerated(EnumType.STRING)
    private SexoTipoPlanificacionFamiliar sexo;

}
