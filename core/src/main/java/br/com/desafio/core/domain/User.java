package br.com.desafio.core.domain;

import br.com.desafio.core.domain.enums.UserTypeEnum;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {

    private java.util.UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserTypeEnum type;
    private TransactionPin transactionPin;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public User(UUID id, String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type, TransactionPin transactionPin, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public User(String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type, TransactionPin transactionPin) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createAt = LocalDateTime.now();
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
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

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (!taxNumber.equals(user.taxNumber)) return false;
        if (!fullName.equals(user.fullName)) return false;
        if (type != user.type) return false;
        if (!transactionPin.equals(user.transactionPin)) return false;
        if (!createAt.equals(user.createAt)) return false;
        return Objects.equals(updateAt, user.updateAt);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + taxNumber.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + transactionPin.hashCode();
        result = 31 * result + createAt.hashCode();
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
