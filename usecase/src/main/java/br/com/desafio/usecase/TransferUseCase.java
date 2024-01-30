package br.com.desafio.usecase;

import br.com.desafio.core.domain.Transaction;
import br.com.desafio.core.exception.InternalServerErrorException;
import br.com.desafio.core.exception.NotFoundException;
import br.com.desafio.core.exception.PinException;
import br.com.desafio.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws Exception;
}
