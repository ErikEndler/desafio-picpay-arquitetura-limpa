package br.com.desafio.application.usecaseimpl;

import br.com.desafio.application.gateway.UserAuthenticateGateway;
import br.com.desafio.core.exception.AuthenticateException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;
import br.com.desafio.usecase.UserAuthenticateUseCase;

import javax.naming.AuthenticationException;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {

        if (!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }
        return true;
    }
}
