package br.com.desafio.application.usecaseimpl;

import br.com.desafio.application.gateway.FindWalletByTaxNumberGateway;
import br.com.desafio.core.domain.Wallet;
import br.com.desafio.core.exception.NotFoundException;
import br.com.desafio.core.exception.enums.ErrorCodeEnum;
import br.com.desafio.usecase.FindWalletByTaxNumberUseCase;

import java.util.Objects;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if (Objects.isNull(wallet)) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
