package br.com.desafio.core.domain;

import br.com.desafio.core.exception.TransactionPinException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class TransactionPin {

    private Long id;
    private User user;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public TransactionPin(Long id, User user, String pin, Integer attempt, Boolean blocked, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public TransactionPin(User user, String pin, Integer attempt, Boolean blocked) {
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createAt = LocalDateTime.now();
    }

    public TransactionPin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    private void pinIsValid(String pin) throws TransactionPinException {
        if (pin.length() != 8)
            throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
