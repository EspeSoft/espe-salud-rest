package com.espe.salud.common.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String object) {
        super(String.format("%s no se encuentra registrado(a) o su estatus es inválido para esta acción", object));
    }

}