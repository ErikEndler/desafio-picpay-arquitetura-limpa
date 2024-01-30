package br.com.desafio.application.gateway;

import br.com.desafio.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
