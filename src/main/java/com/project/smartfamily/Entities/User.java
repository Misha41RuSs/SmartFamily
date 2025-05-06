package com.project.smartfamily.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String role;
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserHome> userHomes;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserHome> administeredHomes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionAccount> transactionAccounts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionFinancialGoal> transactionFinancialGoals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonalTask> personalTasks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DistributedTask> distributedTasks;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<UserHome> getUserHomes() {
        return userHomes;
    }

    public void setUserHomes(List<UserHome> userHomes) {
        this.userHomes = userHomes;
    }

    public List<UserHome> getAdministeredHomes() {
        return administeredHomes;
    }

    public void setAdministeredHomes(List<UserHome> administeredHomes) {
        this.administeredHomes = administeredHomes;
    }
}
