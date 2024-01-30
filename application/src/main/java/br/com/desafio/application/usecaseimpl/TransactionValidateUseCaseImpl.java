package br.com.desafio.application.usecaseimpl;

import br.com.desafio.application.gateway.TransactionValidateGateway;
import br.com.desafio.core.domain.Transaction;
import br.com.desafio.core.exception.TransferException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;
import br.com.desafio.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {
    private final TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if (!transactionValidateGateway.validate(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }
        return true;
    }
}
