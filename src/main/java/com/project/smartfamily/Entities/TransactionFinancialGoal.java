package com.project.smartfamily.Entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_financial_goals")
public class TransactionFinancialGoal {

    @Id
    @Column(name = "transaction_goal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = false)
    private FinancialGoal goal;

    @ManyToOne
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public FinancialGoal getGoal() {
        return goal;
    }

    public void setGoal(FinancialGoal goal) {
        this.goal = goal;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
