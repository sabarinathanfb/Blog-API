package org.scaler.blogapi.users;

import org.scaler.blogapi.users.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController( UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/signnup")
    ResponseEntity<UserResponseDTO> signupUser(){

        // TODO 01:
        // 1. create a UserSignupDTO
        return null;

    }

    @PostMapping("/login")
    ResponseEntity<UserResponseDTO> loginUser(){


        return null;
    }

    @PatchMapping("/{id}")
    ResponseEntity<UserResponseDTO> updateUser(){

        return null;
    }
}
