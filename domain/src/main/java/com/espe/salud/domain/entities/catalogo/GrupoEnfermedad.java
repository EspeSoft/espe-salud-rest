package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCGRUENF", schema = "SALUD")
public class GrupoEnfermedad {

    @Id
    @Basic(optional = false)
    @Column(name = "MZSTCGRUENF_CODIGO")
    private String codigo;

    @Column(name = "MZSTCGRUENF_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "grupoEnfermedadCIE10", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EnfermedadCIE10> tiposEnfermedadCIE10;
}
