package com.espe.salud.report.evolucion;

import com.espe.salud.domain.entities.evolucion.Evolucion;

public interface EvolucionReportService {
    byte[] generateCertificadoMedicoGeneral(Evolucion evolucion);
    byte[] generateCertificadoRecetaMedica(Evolucion evolucion);
}
