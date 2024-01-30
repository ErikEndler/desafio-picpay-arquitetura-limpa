package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.TransferGateway;
import br.com.desafio.core.domain.Transaction;
import br.com.desafio.infrastructure.mapper.TransactionMapper;
import br.com.desafio.infrastructure.mapper.WalletMapper;
import br.com.desafio.infrastructure.repository.TransactionEntityRepository;
import br.com.desafio.infrastructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;

public class TransferGatewayImpl implements TransferGateway {
    private final WalletEntityRepository walletEntityRepository;
    private final TransactionEntityRepository transactionEntityRepository;
    private final WalletMapper walletMapper;
    private final TransactionMapper transactionMapper;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository, WalletMapper walletMapper, TransactionMapper transactionMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntity(transaction.getToWallet()));

            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            return true;
        } catch (Exception e) {
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            return false;
        }
    }
}
