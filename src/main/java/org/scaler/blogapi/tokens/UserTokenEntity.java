package org.scaler.blogapi.tokens;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.scaler.blogapi.common.BaseEntity;
import org.scaler.blogapi.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Date;

@Entity(name = "user_tokens")
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserTokenEntity extends BaseEntity {

    @ManyToOne
    UserEntity user;

    Date expiresAt;


}
