package com.example.forumhub.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    private User user;

    // Getters y Setters
}
