package com.impactsoft.bankingapp.controllers;

import com.impactsoft.bankingapp.entities.dto.bankAccountDTOs.BankAccountDTO;
import com.impactsoft.bankingapp.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<BankAccountDTO> insert(@RequestBody BankAccountDTO bankAccountDto) {
        bankAccountDto = bankAccountService.insert(bankAccountDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bankAccountDto.getId()).toUri();
        return ResponseEntity.created(uri).body(bankAccountDto);
    }

}
