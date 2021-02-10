package com.espe.salud.domain.entities.odontologia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.espe.salud.domain.entities.odontologia.DetalleOdontogramaGrafico;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "MZSTCDET_ODO_COM", schema = "SALUD")
public class DetalleOdontogramaCompuesto extends DetalleOdontogramaGrafico implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name="MZSTCDET_ODO_COM_PIEZAS")
    @CollectionTable(name = "MZSTCDET_ODO_COM_PIE")
    @ElementCollection
    private List<Integer> piezas = new ArrayList<Integer>();
}
