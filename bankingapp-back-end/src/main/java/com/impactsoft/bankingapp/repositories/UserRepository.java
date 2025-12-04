package com.impactsoft.bankingapp.repositories;

import com.impactsoft.bankingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
