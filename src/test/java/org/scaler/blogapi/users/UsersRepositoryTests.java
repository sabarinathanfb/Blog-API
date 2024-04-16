package org.scaler.blogapi.users;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.scaler.blogapi.articles.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsersRepositoryTests {

    @Autowired private UsersRepository usersRepository;



    @Test
    public void createUser(){

        UserEntity userEntity =  UserEntity.builder()
                .username("sabari123")
                .email("sabari@123.com")
                .password("sabari123")
                .build();

        var users = usersRepository.save(userEntity);
        Assertions.assertNotNull(users.getId());
    }

    @Test
    public void findByUsername(){

        UserEntity userEntity1 = new UserEntity(
                "gokul",
                "gokul@123.com",
                "gokul123"
        );
        UserEntity userEntity2 = new UserEntity(
                "keeri",
                "keeri@123.com",
                "keeri123"
        );

        usersRepository.save(userEntity1);
        usersRepository.save(userEntity2);

        var user1 = usersRepository.findByUsername("gokul");
        var user2 = usersRepository.findByUsername("keeri");

        Assertions.assertEquals("gokul@123.com",user1.getEmail());
        Assertions.assertEquals("keeri@123.com",user2.getEmail());




    }

}
