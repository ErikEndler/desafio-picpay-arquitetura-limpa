package br.com.desafio.core.exception;

public class BadRequestException extends Exception {
    private String code;

    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }
}
