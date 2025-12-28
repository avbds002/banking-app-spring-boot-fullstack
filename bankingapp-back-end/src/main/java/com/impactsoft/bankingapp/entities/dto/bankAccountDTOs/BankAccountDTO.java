package com.impactsoft.bankingapp.entities.dto.bankAccountDTOs;

import com.impactsoft.bankingapp.entities.BankAccount;
import com.impactsoft.bankingapp.entities.enums.AccountType;

import java.math.BigDecimal;

public class BankAccountDTO {

    private Long id;

    private String accountNumber;

    private String branch;

    private AccountType type;

    private BigDecimal balance = BigDecimal.ZERO;

    public BankAccountDTO() {
    }

    public BankAccountDTO(Long id, String accountNumber, String branch, AccountType type, BigDecimal balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.branch = branch;
        this.type = type;
        this.balance = balance;
    }

    public BankAccountDTO(BankAccount entity) {
        id = entity.getId();
        accountNumber = entity.getAccountNumber();
        branch = entity.getBranch();
        type = entity.getType();
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBranch() {
        return branch;
    }

    public AccountType getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
