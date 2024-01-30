package br.com.desafio.core.domain;

import br.com.desafio.core.domain.enums.UserTypeEnum;
import br.com.desafio.core.exception.TransferException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {

    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Wallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Wallet(TransactionPin transactionPin, BigDecimal balance, User user) {
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException {
        if (this.user.getType().equals(UserTypeEnum.SHOPKEEPER)) {
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }
        if (this.balance.compareTo(value) < 0) {
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }
        this.balance.subtract(value);
    }

    public void receiveTransfer(BigDecimal value) {
        this.balance.add(value);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        Wallet wallet = (Wallet) o;

        if (!Objects.equals(id, wallet.id)) return false;
        if (!transactionPin.equals(wallet.transactionPin)) return false;
        if (!balance.equals(wallet.balance)) return false;
        if (!user.equals(wallet.user)) return false;
        if (!createAt.equals(wallet.createAt)) return false;
        return Objects.equals(updateAt, wallet.updateAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + transactionPin.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + createAt.hashCode();
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
