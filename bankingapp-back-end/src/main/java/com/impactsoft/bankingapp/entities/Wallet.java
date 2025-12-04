package com.impactsoft.bankingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_wallet")
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount bankAccount;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal totalBalance;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal totalRentability;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    @OneToMany(
            mappedBy = "wallet",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<FinancialApplication> financialApplicationList = new ArrayList<>();

}
