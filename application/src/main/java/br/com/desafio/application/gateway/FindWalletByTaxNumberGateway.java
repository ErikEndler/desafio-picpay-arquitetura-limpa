package br.com.desafio.application.gateway;

import br.com.desafio.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
