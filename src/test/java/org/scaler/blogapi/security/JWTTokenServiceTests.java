package org.scaler.blogapi.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.scaler.blogapi.security.jwt.JWTTokenService;

public class JWTTokenServiceTests {

    private final JWTTokenService jwtTokenService = new JWTTokenService();

    @Test
    public void testCreateAuthToken(){
        String username = "sabari123";
        String token = jwtTokenService.createAuthToken(username);
        System.out.println(token);
        Assertions.assertNotNull(token);
    }

    @Test
    public void testTokenVerification(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJzYWJhcmkxMjMiLCJpc3MiOiJibG9nLWFwaSIsImlhdCI6MTcxMzI2MzI3OCwiZXhwIjoxNzEzMzQ5Njc4fQ.4OpUBXte4JRkzaM43eQYNPmrqM0iyLyIUOs62f96br4";
        String username = jwtTokenService.getUsernameFromToken(token);
        Assertions.assertEquals("sabari123",username);
    }
}
