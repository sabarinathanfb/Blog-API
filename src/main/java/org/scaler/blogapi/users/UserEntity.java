package org.scaler.blogapi.users;

import jakarta.persistence.*;
import lombok.*;
import org.scaler.blogapi.articles.ArticleEntity;
import org.scaler.blogapi.common.BaseEntity;

import java.util.List;


@Getter
@RequiredArgsConstructor
@ToString
@Entity(name = "users")
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @NonNull
    @Column(nullable = false,unique = true)
    String username;
    @NonNull
    @Column(nullable = false,unique = true)
    String email;
    @NonNull
    @Column(nullable = false)
    String password;

    @Column
    String bio;


    @ManyToMany(targetEntity = UserEntity.class, mappedBy = "following")
    List<UserEntity> followers;

    @ManyToMany
    List<UserEntity> following;

    @ManyToMany(targetEntity = ArticleEntity.class, mappedBy = "likes")
    List<ArticleEntity> favouriteArticles;




}
