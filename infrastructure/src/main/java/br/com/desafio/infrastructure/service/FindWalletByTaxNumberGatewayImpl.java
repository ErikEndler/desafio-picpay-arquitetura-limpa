package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.FindWalletByTaxNumberGateway;
import br.com.desafio.core.domain.Wallet;
import br.com.desafio.infrastructure.mapper.WalletMapper;
import br.com.desafio.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {
    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
