package org.scaler.blogapi.users.dto;


import lombok.Data;
import lombok.NonNull;

@Data
public class LoginUserRequestDTO {

    @NonNull
    String username;
    @NonNull
    String password;

}
