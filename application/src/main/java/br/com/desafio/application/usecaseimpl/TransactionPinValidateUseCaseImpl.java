package br.com.desafio.application.usecaseimpl;

import br.com.desafio.application.gateway.TransactionPinValidateGateway;
import br.com.desafio.core.domain.TransactionPin;
import br.com.desafio.core.exception.PinException;
import br.com.desafio.core.exception.TransferException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;
import br.com.desafio.usecase.TransactionPinValidateUseCase;
import br.com.desafio.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    private final TransactionPinValidateGateway transactionPinValidateGateway;
    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway,
                                             UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws TransferException, PinException {
        if (transactionPin.getBlocked())
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        if (!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }
        if (transactionPin.getAttempt() < 3) {
            transactionPin.restoreAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return true;
    }
}
