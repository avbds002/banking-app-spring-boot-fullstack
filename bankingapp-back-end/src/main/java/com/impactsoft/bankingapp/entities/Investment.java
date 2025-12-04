package com.impactsoft.bankingapp.entities;

import com.impactsoft.bankingapp.entities.enums.InvestmentRisk;
import com.impactsoft.bankingapp.entities.enums.InvestmentType;
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
@Table(name = "tb_investment")
public class Investment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvestmentType type;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal minimumAmount;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal annualProfitability;

    @Column(nullable = false)
    private Integer minimumTermInDays;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvestmentRisk risk;

    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    @OneToMany(
            mappedBy = "investment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<FinancialApplication> financialApplicationList = new ArrayList<>();
}
