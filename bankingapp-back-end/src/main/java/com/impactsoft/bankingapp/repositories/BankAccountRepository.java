package com.impactsoft.bankingapp.repositories;

import com.impactsoft.bankingapp.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
