package br.com.desafio.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax number invalid", "ON-0001"),
    TR0001("User shopkeeper cannot make transfer", "TR-0001"),
    TR0002("Unavailable balancer", "TR-0002"),
    TRP0001("Pin invalid", "TRP-0001");
    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
