package br.com.desafio.application.gateway;

import br.com.desafio.core.domain.TransactionPin;
import br.com.desafio.core.domain.User;
import br.com.desafio.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet);
}
