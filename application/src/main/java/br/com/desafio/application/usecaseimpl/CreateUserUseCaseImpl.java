package br.com.desafio.application.usecaseimpl;

import br.com.desafio.application.gateway.CreateUserGateway;
import br.com.desafio.core.domain.TransactionPin;
import br.com.desafio.core.domain.User;
import br.com.desafio.core.domain.Wallet;
import br.com.desafio.core.exception.EmailException;
import br.com.desafio.core.exception.InternalServerErrorException;
import br.com.desafio.core.exception.TaxNumberException;
import br.com.desafio.core.exception.TransactionPinException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;
import br.com.desafio.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;
    private final CreateUserGateway createUserGateway;


    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException {
        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }
        if (!emailAvailableUseCase.emailAvailableEmail(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
        if (!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
