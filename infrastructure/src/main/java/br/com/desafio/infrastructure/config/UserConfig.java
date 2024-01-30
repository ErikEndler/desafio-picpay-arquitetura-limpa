package br.com.desafio.infrastructure.config;

import br.com.desafio.application.gateway.CreateUserGateway;
import br.com.desafio.application.gateway.EmailAvailableGateway;
import br.com.desafio.application.gateway.TaxNumberAvailableGateway;
import br.com.desafio.application.usecaseimpl.CreateUserUseCaseImpl;
import br.com.desafio.application.usecaseimpl.EmailAvailableUseCaseImpl;
import br.com.desafio.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import br.com.desafio.usecase.CreateUserUseCase;
import br.com.desafio.usecase.EmailAvailableUseCase;
import br.com.desafio.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}
