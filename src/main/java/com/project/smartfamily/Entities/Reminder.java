package com.project.smartfamily.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @Column(name = "reminder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "reminder_date")
    private Date reminderDate;

    @ManyToOne
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;

    // геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
