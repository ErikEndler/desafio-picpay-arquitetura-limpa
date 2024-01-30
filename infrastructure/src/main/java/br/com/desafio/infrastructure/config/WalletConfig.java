package br.com.desafio.infrastructure.config;

import br.com.desafio.application.gateway.*;
import br.com.desafio.application.usecaseimpl.*;
import br.com.desafio.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {
    @Bean
    public FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberUseCaseImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public ConsultBalanceUseCase consultBalanceUseCase(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase) {
        return new ConsultBalanceUseCaseImpl(findWalletByTaxNumberUseCase);
    }

    @Bean
    public TransactionValidateUseCase transactionValidateUseCase(TransactionValidateGateway transactionValidateGateway) {
        return new TransactionValidateUseCaseImpl(transactionValidateGateway);
    }

    @Bean
    public CreateTransactionUseCase createTransactionUseCase(CreateTransactionGateway createTransactionGateway) {
        return new CreateTransactionUseCaseImpl(createTransactionGateway);
    }

    @Bean
    public UserNotificationUserCase userNotificationUserCase(UserNotificationGateway userNotificationGateway) {
        return new UserNotificationUserCaseImpl(userNotificationGateway);
    }
    @Bean
    public UpdateTransactionPinUseCase updateTransactionPinUseCase(){
        return
    }

    @Bean
    public TransactionPinValidateUseCase transactionPinValidateUseCase(
            TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        return new TransactionPinValidateUseCaseImpl(transactionPinValidateGateway, updateTransactionPinUseCase);
    }

    @Bean
    public TransferUseCase transferUseCase(
            FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase,
            CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway,
            UserNotificationUserCase userNotificationUserCase, TransactionPinValidateUseCase transactionPinValidateUseCase) {
        return new TransferUseCaseImpl(
                findWalletByTaxNumberUseCase,
                transactionValidateUseCase,
                createTransactionUseCase,
                transferGateway,
                userNotificationUserCase,
                transactionPinValidateUseCase);
    }
}
