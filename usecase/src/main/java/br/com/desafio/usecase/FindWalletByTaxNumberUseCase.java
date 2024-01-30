package br.com.desafio.usecase;

import br.com.desafio.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
