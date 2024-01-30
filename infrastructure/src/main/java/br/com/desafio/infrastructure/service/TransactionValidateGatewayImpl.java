package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.TransactionValidateGateway;
import br.com.desafio.core.domain.Transaction;
import br.com.desafio.infrastructure.client.ApiValidateService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {
    private final ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        var response = apiValidateService.validate();
        return response.filter(apiValidateResponse -> Objects.equals(apiValidateResponse.message(), "Autorizado")).isPresent();
    }
}
