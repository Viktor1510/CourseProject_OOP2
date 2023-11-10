package com.example.courseproject_oop2;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID notificationId;
    @ManyToOne
    private User user;

    private String type;

    private String content;
    private Date date;

    public Notification(User user, String type, String content, Date date) {
        this.user = user;
        this.type = type;
        this.content = content;
        this.date = date;
    }

    public Notification() {

    }


    public UUID getNotificationId() {
        return notificationId;
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
