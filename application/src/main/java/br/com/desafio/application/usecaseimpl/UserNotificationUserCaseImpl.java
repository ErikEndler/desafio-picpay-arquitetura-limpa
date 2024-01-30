package br.com.desafio.application.usecaseimpl;

import br.com.desafio.application.gateway.UserNotificationGateway;
import br.com.desafio.core.domain.Transaction;
import br.com.desafio.usecase.UserNotificationUserCase;

public class UserNotificationUserCaseImpl implements UserNotificationUserCase {
    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationUserCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notified(Transaction transaction, String email) {
        return userNotificationGateway.notify(transaction, email);
    }
}
