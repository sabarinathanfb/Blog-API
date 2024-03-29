package org.scaler.blogapi.comments;

import jakarta.persistence.*;
import lombok.Getter;
import org.scaler.blogapi.articles.ArticleEntity;
import org.scaler.blogapi.common.BaseEntity;
import org.scaler.blogapi.users.UserEntity;

import java.util.UUID;

@Getter
@Entity(name = "comments")
public class CommentsEntity extends BaseEntity {

    @Column(length = 100)
    String title;

    @Column(nullable = false,length = 1000)
    String body;

    @ManyToOne
    UserEntity author;

    @ManyToOne
    ArticleEntity article;


}
