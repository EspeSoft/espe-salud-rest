package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MZSTCTIPESTCOM", schema = "SALUD")
public class TipoEstudioComplementario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPESTCOM_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPESTCOM_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "nombreEstudio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EstudioComplementario> tipoEstudioComplementario;
}
