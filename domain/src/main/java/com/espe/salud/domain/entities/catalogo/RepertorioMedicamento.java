package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.evolucion.Prescripcion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCREPMED", schema = "SALUD")
public class RepertorioMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCREPMED_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCREPMED_NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "medicamento")
    private List<Prescripcion> prescripciones;

    @Override
    public String toString() {
        return this.getNombre();
    }
}
