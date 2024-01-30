package br.com.desafio.application.gateway;

import br.com.desafio.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {
    Boolean validate(TransactionPin transactionPin);
}
