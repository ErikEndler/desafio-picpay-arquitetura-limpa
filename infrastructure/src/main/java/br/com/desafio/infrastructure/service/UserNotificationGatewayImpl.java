package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.UserNotificationGateway;
import br.com.desafio.core.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    @Override
    public Boolean notify(Transaction transaction, String email) {
        return true;
    }
}
