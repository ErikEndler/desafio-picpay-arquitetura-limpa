package br.com.desafio.application.usecaseimpl;

import br.com.desafio.application.gateway.CreateTransactionGateway;
import br.com.desafio.core.domain.Transaction;
import br.com.desafio.core.exception.TransferException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;
import br.com.desafio.usecase.CreateTransactionUseCase;

import java.util.Objects;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws Exception {
        var transactionSaved = createTransactionGateway.create(transaction);
        if (Objects.isNull(transactionSaved)) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        return transactionSaved;
    }
}
