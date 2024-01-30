package br.com.desafio.infrastructure.repository;

import br.com.desafio.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByUserEntityTaxNumber(String TaxNumber);
}
