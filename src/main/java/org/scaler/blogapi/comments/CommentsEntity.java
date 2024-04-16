package org.scaler.blogapi.comments;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.scaler.blogapi.articles.ArticleEntity;
import org.scaler.blogapi.common.BaseEntity;
import org.scaler.blogapi.users.UserEntity;

import java.util.UUID;

@Getter
@Entity(name = "comments")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
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
