package br.com.desafio.usecase;

import br.com.desafio.core.domain.User;
import br.com.desafio.core.exception.EmailException;
import br.com.desafio.core.exception.InternalServerErrorException;
import br.com.desafio.core.exception.TaxNumberException;
import br.com.desafio.core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException;
}
