package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import com.espe.salud.domain.entities.antecedente.EstudioComplementario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPENF", schema = "SALUD")
public class TipoEnfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPENF_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPENF_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "tipoEnfermedadFamiliar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AntecedentePatologicoFamiliar> antecedentesPatologicosFamiliares;
}
