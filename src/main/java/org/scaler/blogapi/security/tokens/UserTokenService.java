package org.scaler.blogapi.security.tokens;

import org.scaler.blogapi.security.TokenService;
import org.scaler.blogapi.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class UserTokenService implements TokenService {
    private final UserTokenRepository userTokenRepository;
    private final UsersRepository usersRepository;

    public UserTokenService(

            @Autowired UserTokenRepository userTokenRepository,
            @Autowired UsersRepository usersRepository
    ){
        this.userTokenRepository = userTokenRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public String createAuthToken(String username) {
        var user = usersRepository.findByUsername(username);
        var token = userTokenRepository.save(UserTokenEntity.builder()
                .user(user)
                .expiresAt(new Date(System.currentTimeMillis() + 100 * 60 * 60 *24))
                .build()
        );

        return token.getId().toString();
    }

    @Override
    public String getUsernameFromToken(String token) throws IllegalStateException {

        var savedToken = userTokenRepository.findById(UUID.fromString(token));
        if(savedToken.isPresent()) {
            var user = savedToken.get().getUser();
            if(user != null){
                return user.getUsername();
            }
        }

        return null;
    }
}
