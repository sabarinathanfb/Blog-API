package org.scaler.blogapi.comments;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "comments")
public class CommentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",nullable = false)
    private UUID id;


    public UUID getId() {
        return id;
    }
}
