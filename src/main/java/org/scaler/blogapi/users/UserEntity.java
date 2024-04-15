package org.scaler.blogapi.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.scaler.blogapi.common.BaseEntity;

import java.util.UUID;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    String username;
    @Column(nullable = false,unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @Column
    String bio;




}
