package org.scaler.blogapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;


    public UsersService(@Autowired UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserEntity createUser(String username,String password,String email){
        //TODO 02:
    }
}
