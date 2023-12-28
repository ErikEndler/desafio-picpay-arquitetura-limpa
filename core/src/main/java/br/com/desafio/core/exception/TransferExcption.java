package br.com.desafio.core.exception;

public class TransferExcption extends Exception {
    private String code;

    public TransferExcption(String message, String code) {
        super(message);
        this.code = code;
    }
}
