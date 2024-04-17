package org.scaler.blogapi.security;


import org.scaler.blogapi.security.jwt.JWTTokenService;
import org.scaler.blogapi.security.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import java.security.PublicKey;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private TokenService tokenService;

   public SecurityConfig(TokenService tokenService) {
       this.tokenService = tokenService;
   }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{

        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests
                ((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET,"/articles").permitAll()
                        .requestMatchers(HttpMethod.POST,"/users/signup").permitAll()
                        .requestMatchers(HttpMethod.POST,"/users/login").permitAll()
                        .requestMatchers(HttpMethod.GET,"/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                );
        http.addFilterBefore(new JwtAuthenticationFilter(tokenService), AnonymousAuthenticationFilter.class);
        return http.build();
    }

}
