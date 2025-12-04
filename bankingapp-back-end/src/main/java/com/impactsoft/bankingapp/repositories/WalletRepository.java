package com.impactsoft.bankingapp.repositories;

import com.impactsoft.bankingapp.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
