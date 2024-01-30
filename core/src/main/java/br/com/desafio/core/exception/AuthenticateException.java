package br.com.desafio.core.exception;

public class AuthenticateException extends Exception {
    private String code;

    public AuthenticateException(String message, String code) {
        super(message);
        this.code = code;
    }
}
