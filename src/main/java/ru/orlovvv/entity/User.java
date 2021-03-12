package ru.orlovvv.entity;

import ru.orlovvv.entity.enums.Role;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String login;
    private String email;
    private String password;
    private String bio;
    private LocalDateTime registerDate;

    private Set<Role> role = new HashSet<>();
    private List<Post> posts = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.registerDate = LocalDateTime.now();
    }
}
