package com.impactsoft.bankingapp.repositories;

import com.impactsoft.bankingapp.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}
