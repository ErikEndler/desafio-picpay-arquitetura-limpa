package br.com.desafio.usecase;

import br.com.desafio.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}
