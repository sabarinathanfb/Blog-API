package org.scaler.blogapi.users.dto;

import lombok.*;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponseDTO {

    @NonNull
    String username;
    @NonNull
    String password;

    String bio;


    String token;
}
