package br.com.desafio.application.gateway;

import br.com.desafio.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction) throws Exception;
}
