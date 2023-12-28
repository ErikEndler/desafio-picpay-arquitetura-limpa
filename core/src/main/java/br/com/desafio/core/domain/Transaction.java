package br.com.desafio.core.domain;

import br.com.desafio.core.domain.enums.TransactionStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private Long id;
    private Wallet fromWallet;
    private Wallet toWallet;
    private BigDecimal value;
    private TransactionStatusEnum status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Transaction() {
    }

    public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal value) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = TransactionStatusEnum.CREATED;
        this.createAt = LocalDateTime.now();
    }

    public Transaction(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public Wallet getFromWallet() {
        return fromWallet;
    }

    public Wallet getToWallet() {
        return toWallet;
    }

    public BigDecimal getValue() {
        return value;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!fromWallet.equals(that.fromWallet)) return false;
        if (!toWallet.equals(that.toWallet)) return false;
        if (!value.equals(that.value)) return false;
        if (status != that.status) return false;
        if (!createAt.equals(that.createAt)) return false;
        return Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + fromWallet.hashCode();
        result = 31 * result + toWallet.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createAt.hashCode();
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
