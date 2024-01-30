package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.CreateTransactionGateway;
import br.com.desafio.core.domain.Transaction;
import br.com.desafio.infrastructure.mapper.TransactionMapper;
import br.com.desafio.infrastructure.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {
    private final TransactionEntityRepository transactionEntityRepository;
    private final TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) {
        try {
            var transactionEntity = transactionMapper.toTransactionEntity(transaction);
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        } catch (Exception e) {
            return null;
        }
    }
}
