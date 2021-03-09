package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.antecedente.ConsumoNocivo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPCONNOC", schema = "SALUD")
public class TipoConsumoNocivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPCONNOC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPCONNOC_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "nombreConsumoNocivo", fetch = FetchType.LAZY)
    private List<ConsumoNocivo> consumosNocivos;
}