package br.com.desafio.usecase;

import br.com.desafio.core.domain.Transaction;

public interface UserNotificationUserCase {
    Boolean notified(Transaction transaction, String email);
}
