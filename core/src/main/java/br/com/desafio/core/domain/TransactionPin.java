package br.com.desafio.core.domain;

import br.com.desafio.core.exception.TransactionPinException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {

    private Long id;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public TransactionPin(Long id, String pin, Integer attempt, Boolean blocked, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
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

    public void setAttempt() {
        if (attempt == 1) {
            blocked = true;
            attempt = 0;
        } else
            attempt = attempt - 1;
    }

    public void restoreAttempt() {
        attempt = 3;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionPin that = (TransactionPin) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!pin.equals(that.pin)) return false;
        if (!attempt.equals(that.attempt)) return false;
        if (!blocked.equals(that.blocked)) return false;
        if (!createAt.equals(that.createAt)) return false;
        return Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + pin.hashCode();
        result = 31 * result + attempt.hashCode();
        result = 31 * result + blocked.hashCode();
        result = 31 * result + createAt.hashCode();
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
