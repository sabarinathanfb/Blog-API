package org.scaler.blogapi.users.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserResponseDTO {

    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String bio;


    String token;
}
