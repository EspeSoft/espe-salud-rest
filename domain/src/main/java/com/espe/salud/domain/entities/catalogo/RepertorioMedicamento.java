package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return this.getNombre();
    }
}
