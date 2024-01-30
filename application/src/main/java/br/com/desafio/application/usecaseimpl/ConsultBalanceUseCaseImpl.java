package br.com.desafio.application.usecaseimpl;

import br.com.desafio.usecase.ConsultBalanceUseCase;
import br.com.desafio.usecase.FindWalletByTaxNumberUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    public ConsultBalanceUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception {
        return findWalletByTaxNumberUseCase.findByTaxNumber(taxNumber).getBalance();
    }
}
