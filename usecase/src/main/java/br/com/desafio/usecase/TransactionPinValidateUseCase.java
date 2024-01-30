package br.com.desafio.usecase;

import br.com.desafio.core.domain.TransactionPin;
import br.com.desafio.core.exception.PinException;
import br.com.desafio.core.exception.TransferException;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
