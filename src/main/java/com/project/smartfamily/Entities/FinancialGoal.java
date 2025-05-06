package com.project.smartfamily.Entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "financial_goals")
public class FinancialGoal {

    @Id
    @Column(name = "goal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal target;

    @ManyToOne
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionFinancialGoal> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public List<TransactionFinancialGoal> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionFinancialGoal> transactions) {
        this.transactions = transactions;
    }
}
