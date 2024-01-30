package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.TaxNumberAvailableGateway;
import br.com.desafio.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.desafio.infrastructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {
    private final UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean TaxNumberAvailable(String taxNumber) {
        log.info("Inicio da verificação se o TaxNumber está disponível");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
