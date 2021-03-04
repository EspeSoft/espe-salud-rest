package com.espe.salud.common.exception;

/**
 * Clase para manejar excepciones lanzadas por errores genéricos de la aplicación
 *
 * @author espe salud
 */
public class EspeSaludException extends RuntimeException {

    public EspeSaludException(String message) {
        super(message);
    }

}