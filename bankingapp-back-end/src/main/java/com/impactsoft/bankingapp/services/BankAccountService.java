package com.impactsoft.bankingapp.services;

import com.impactsoft.bankingapp.entities.BankAccount;
import com.impactsoft.bankingapp.entities.dto.bankAccountDTOs.BankAccountDTO;
import com.impactsoft.bankingapp.repositories.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountDTO insert(BankAccountDTO bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        copyDtoToEntity(bankAccountDto, bankAccount);
        bankAccount = bankAccountRepository.save(bankAccount);

        return new BankAccountDTO(bankAccount);
    }

    private void copyDtoToEntity(BankAccountDTO bankAccountDto, BankAccount entity) {
        entity.setAccountNumber(bankAccountDto.getAccountNumber());
        entity.setBranch(bankAccountDto.getBranch());
        entity.setType(bankAccountDto.getType());
    }
}
