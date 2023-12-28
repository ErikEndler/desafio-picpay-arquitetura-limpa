package br.com.desafio.core.exception;

public class TransactionPinExcption extends Exception {
    private String code;

    public TransactionPinExcption(String message, String code) {
        super(message);
        this.code = code;
    }
}
