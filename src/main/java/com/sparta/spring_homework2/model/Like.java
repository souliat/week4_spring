package com.sparta.spring_homework2.model;

import javax.persistence.*;

@Entity
public class Like {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Long commentId;

    public Like (String username, Long commentId) {
        this.username = username;
        this.commentId = commentId;
    }
}
