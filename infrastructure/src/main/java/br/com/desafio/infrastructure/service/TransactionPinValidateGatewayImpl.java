package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.TransactionPinValidateGateway;
import br.com.desafio.core.domain.TransactionPin;
import br.com.desafio.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {
    private final TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {
        var transactionPinSaved = transactionPinEntityRepository.findById(transactionPin.getId());
        if (transactionPinSaved.isEmpty())
            return false;
        return !Objects.equals(transactionPinSaved.get().getPin(), transactionPin.getPin());
    }
}
