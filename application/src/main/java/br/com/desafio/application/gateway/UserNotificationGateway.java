package br.com.desafio.application.gateway;

import br.com.desafio.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notify(Transaction transaction, String email);
}
