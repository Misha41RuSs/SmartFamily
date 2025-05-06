package com.project.smartfamily.Entities;

import jakarta.persistence.*;

@Entity
public class UserHome {
    @Id
    @Column(name = "")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
