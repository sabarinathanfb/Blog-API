package org.scaler.blogapi.security.tokens;

import jakarta.servlet.http.HttpServletRequest;
import org.scaler.blogapi.security.TokenService;
import org.scaler.blogapi.security.UserAuthentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

public class UserAuthenticationFilter extends AuthenticationFilter {

    public UserAuthenticationFilter(TokenService tokenService) {
        super(new UserAuthenticationManager(tokenService), new BearerTokenAuthenticationConverter());

        /**
         * Every time authentication succeeds, we want to set the Authentication Object in the SecurityContext of Spring
         */
        this.setSuccessHandler((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
    }

    /**
     * This class is responsible for converting the request into an Authentication Object
     */

    static class BearerTokenAuthenticationConverter implements AuthenticationConverter {


        @Override
        public Authentication convert(HttpServletRequest request) {
            if (request.getHeader("Authorization") != null) {
                String token = request.getHeader("Authorization").replace("Bearer ", "");
                return new UserAuthentication(token);

            }
            return null;
        }
    }

    static class UserAuthenticationManager implements AuthenticationManager{

        private final TokenService tokenService;

        public UserAuthenticationManager(TokenService tokenService) {
            this.tokenService = tokenService;
        }


        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {

            if(authentication instanceof  UserAuthentication){
                var userAuthentication = (UserAuthentication) authentication;
                var username = tokenService.getUsernameFromToken(userAuthentication.getCredentials());
                if(username != null){
                    userAuthentication.setUser(username);
                    return userAuthentication;
                }
            }
            return null;
        }
    }




}
