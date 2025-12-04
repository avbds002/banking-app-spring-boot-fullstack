package com.impactsoft.bankingapp.repositories;

import com.impactsoft.bankingapp.entities.FinancialApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialApplicationRepository extends JpaRepository<FinancialApplication, Long> {
}
