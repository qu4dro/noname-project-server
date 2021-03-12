package ru.orlovvv.entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private Long userId;
    private Post post;
    private String username;
    private String message;
    private LocalDateTime createdTime;

    @PrePersist
    protected void onCreate() {
        this.createdTime = LocalDateTime.now();
    }
}
