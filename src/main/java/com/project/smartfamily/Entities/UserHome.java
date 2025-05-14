package com.project.smartfamily.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_homes")
public class UserHome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // владелец связи — пользователь
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // владелец связи — дом
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;

    // флаг администратора в этом доме
    @Column(name = "is_administrator", nullable = false)
    private boolean administrator;

    // ======== getters / setters ========
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Home getHome() {
        return home;
    }
    public void setHome(Home home) {
        this.home = home;
    }

    public boolean isAdministrator() {
        return administrator;
    }
    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
