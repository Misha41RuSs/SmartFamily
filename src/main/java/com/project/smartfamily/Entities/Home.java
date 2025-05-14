package com.project.smartfamily.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "homes")
public class Home {

    @Id
    @Column(name = "home_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private Date creationDate;

    // ВСЕ связи к пользователям
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserHome> userHomes;

    // ======== getters / setters ========
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<UserHome> getUserHomes() {
        return userHomes;
    }
    public void setUserHomes(List<UserHome> userHomes) {
        this.userHomes = userHomes;
    }
}
