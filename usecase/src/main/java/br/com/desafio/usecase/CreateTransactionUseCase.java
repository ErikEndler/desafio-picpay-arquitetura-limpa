package br.com.desafio.usecase;

import br.com.desafio.core.domain.Transaction;
import br.com.desafio.core.exception.TransferException;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transactions) throws Exception;
}
