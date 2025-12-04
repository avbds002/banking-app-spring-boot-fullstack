package com.impactsoft.bankingapp.repositories;

import com.impactsoft.bankingapp.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
