package br.com.desafio.core.domain;

import br.com.desafio.core.domain.enums.UserTypeEnum;
import br.com.desafio.core.exception.TransferException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {

    private Long id;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Wallet(BigDecimal balance, User user) {
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
}
