package com.example.CourseProject_OOP;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;
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


    public Long getNotificationId() {
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
