package com.espe.salud.report.evolucion;

import com.espe.salud.common.exception.EspeSaludException;
import com.espe.salud.common.exception.enums.TipoReporte;
import com.espe.salud.domain.entities.catalogo.Dispensario;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.usuario.AreaSalud;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class EvolucionReportServiceImpl implements EvolucionReportService {

    @Override
    public byte[] generateCertificadoMedicoGeneral(Evolucion evolucion) {
        try {
            //Select template
            StringBuilder sbTemplate = new StringBuilder("com.espe.salud.report/");
            sbTemplate.append(TipoReporte.CERTIFICADO_MEDICO_GENERAL.getKey());
            sbTemplate.append(".jrxml");
            String template = sbTemplate.toString();
            InputStream reportStream = ClassLoader.getSystemResources(template).nextElement().openStream();

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            Dispensario dispensario = evolucion.getDispensario();
            AreaSalud areaSalud = evolucion.getAreaSalud();

            final Map<String, Object> parameters = new HashMap<>();
            parameters.put("unidadOperativa", dispensario.getUnidadOperativa());
            parameters.put("instituacionSistema", dispensario.getInstitucionSistema());
            parameters.put("areaSalud", areaSalud.getNombre());
            parameters.put("prescripcionesDataSource", new JRBeanCollectionDataSource(evolucion.getPrescripciones()));

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            if (jasperPrint == null) {
                throw new EspeSaludException("No se pudo generar el certificado");
            }
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new EspeSaludException("Ocurrió un error interno al generar el certificado médico en PDF");
        }
    }
}
