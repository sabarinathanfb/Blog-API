package org.scaler.blogapi.articles;

import jakarta.persistence.*;
import lombok.*;
import org.scaler.blogapi.common.BaseEntity;
import org.scaler.blogapi.users.UserEntity;

import java.util.List;

@Getter
@Entity(name = "articles")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleEntity extends BaseEntity {

    @NonNull
    @Column(nullable = false,length = 150)
    String title;

    @NonNull
    @Column(nullable = false,length = 100)
    String slug;
    @Column(length = 250)
    String subtitle;

    @NonNull
    @Column(nullable = false,length = 3000)
    String body;

    //TODO: see how to implement this(without making other tables)
    //@Column
    //String[] tags;

    @NonNull
    @ManyToOne
    UserEntity author;

    @ManyToMany(targetEntity = UserEntity.class)
    @JoinTable(
            name = "article_likes",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<UserEntity> likes;

}
