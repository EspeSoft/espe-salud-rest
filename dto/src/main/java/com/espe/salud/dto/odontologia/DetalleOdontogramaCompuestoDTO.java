package com.espe.salud.dto.odontologia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DetalleOdontogramaCompuestoDTO extends DetalleOdontogramaGraficoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private List<Integer> piezas = new ArrayList<Integer>();
}