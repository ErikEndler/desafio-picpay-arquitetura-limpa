package br.com.desafio.infrastructure.service;

import br.com.desafio.application.gateway.CreateUserGateway;
import br.com.desafio.core.domain.User;
import br.com.desafio.core.domain.Wallet;
import br.com.desafio.infrastructure.mapper.TransactionPinMapper;
import br.com.desafio.infrastructure.mapper.UserMapper;
import br.com.desafio.infrastructure.mapper.WalletMapper;
import br.com.desafio.infrastructure.repository.TransactionPinEntityRepository;
import br.com.desafio.infrastructure.repository.UserEntityRepository;
import br.com.desafio.infrastructure.repository.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static br.com.desafio.infrastructure.utils.Utilities.log;


@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final TransactionPinMapper transactionPinMapper;
    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {
        try {
            log.info("Inicio da criação do usuário::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            log.info("Usuário criado com sucesso::CreateUserGatewayImpl");
            return true;

        } catch (Exception e) {
            log.error("Houve um erro na criação do usuário::CreateUserGatewayImpl");
            return false;
        }
    }
}
