package br.com.desafio.core.exception.enums;

public enum ErrorCodeEnum {
    ON0001("Tax number invalid", "ON-0001"),
    ON0002("Tax number unavailable", "ON-0002"),
    ON0003("Email unavailable", "ON-0003"),
    ON0004("There was an error creating the user", "ON-0004"),
    TR0001("User shopkeeper cannot make transfer", "TR-0001"),
    TR0002("Unavailable balancer", "TR-0002"),
    TR0003("There was an error when making the transfer", "TR-0003"),
    TR0004("Unauthorized transfer", "TR-0004"),
    TRP0001("Pin invalid", "TRP-0001"),
    WA0001("Wallet not found", "WA-0001"),
    ATH0001("Authentication error", "ATH-0001"),

    PIN0001("Transaction pin blocked", "PIN-0001"),
    PIN0002("Incorrect pin", "PIN-0002");
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
