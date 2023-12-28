package br.com.desafio.usecase;

import br.com.desafio.core.domain.User;

public interface FindUserByTextNumberUseCase {
    User findByTaxNumber(String taxNumber);
}
