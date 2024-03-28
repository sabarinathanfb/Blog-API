package org.scaler.blogapi.articles;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "articles")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",nullable = false)
    private UUID id;


    public UUID getId() {
        return id;
    }
}
