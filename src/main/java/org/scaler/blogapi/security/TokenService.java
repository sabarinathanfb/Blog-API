package org.scaler.blogapi.security;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    /**
     * Create a Jwt or Server-Side token for the given username
     * @param username
     * @return
     */
    String createAuthToken(String username);

    /**
     *
     * verifies the given token and return username
     *
     * @param token
     * @return
     * @throws IllegalStateException
     */
    String getUsernameFromToken(String token) throws IllegalStateException;

}
