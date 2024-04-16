package org.scaler.blogapi;

import org.modelmapper.ModelMapper;
import org.scaler.blogapi.security.JWTTokenService;
import org.scaler.blogapi.security.TokenService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public ModelMapper modelMapper(){

		return new ModelMapper();
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public TokenService tokenService(){
		return new JWTTokenService();
	}


}
