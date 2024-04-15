package org.scaler.blogapi.users;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired private UserRepository usersRepository;



    @Test
    public void createUser(){

        UserEntity userEntity = new UserEntity(
                "sabari123",
                "sabari@123.com",
                "sabari123",
                "sabari is a honest person"
        );
        var users = usersRepository.save(userEntity);
        Assertions.assertNotNull(users.getId());

    }

    @Test
    public void findByUsername(){

        UserEntity userEntity1 = new UserEntity(
                "gokul",
                "gokul@123.com",
                "gokul123",
                "gokul is a Nice person"
        );
        UserEntity userEntity2 = new UserEntity(
                "keeri",
                "keeri@123.com",
                "keeri123",
                "keeri is a Good person"
        );

        usersRepository.save(userEntity1);
        usersRepository.save(userEntity2);

        var user1 = usersRepository.findByUsername("gokul");
        var user2 = usersRepository.findByUsername("keeri");

        Assertions.assertEquals("gokul@123.com",user1.getEmail());
        Assertions.assertEquals("keeri@123.com",user2.getEmail());




    }

}
