package org.scaler.blogapi.articles;

import jakarta.persistence.*;
import lombok.Getter;
import org.scaler.blogapi.common.BaseEntity;
import org.scaler.blogapi.users.UserEntity;

@Getter
@Entity(name = "articles")
public class ArticleEntity extends BaseEntity {

    @Column(nullable = false,length = 150)
    String title;
    @Column(nullable = false,length = 100)
    String slug;
    @Column(length = 250)
    String subtitle;
    @Column(nullable = false,length = 3000)
    String body;

    @ManyToOne
    UserEntity author;

}
