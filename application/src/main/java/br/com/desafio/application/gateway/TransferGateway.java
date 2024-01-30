package br.com.desafio.application.gateway;

import br.com.desafio.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
