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

    // ВСЕ дома, в которых состоит пользователь
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserHome> userHomes;

    // Для удобства можно отфильтровать только администрируемые:
    @Transient
    public List<UserHome> getAdministeredHomes() {
        return userHomes.stream()
                .filter(UserHome::isAdministrator)
                .toList();
    }

    // ======== getters / setters ========
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
}
