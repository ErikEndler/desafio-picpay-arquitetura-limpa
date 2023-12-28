package br.com.desafio.usecase;

import br.com.desafio.core.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
