package com.espe.salud.common.exception;

public class DuplicatedFieldException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicatedFieldException(String errorMessage) {
        super(errorMessage);
    }
}
