package org.scaler.blogapi.users;

import jakarta.persistence.*;
import lombok.Getter;
import org.scaler.blogapi.common.BaseEntity;

import java.util.UUID;


@Getter
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
