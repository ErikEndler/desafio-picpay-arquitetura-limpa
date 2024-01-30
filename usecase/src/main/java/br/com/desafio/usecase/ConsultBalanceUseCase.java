package br.com.desafio.usecase;

import br.com.desafio.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(String taxNumber) throws Exception;
}
