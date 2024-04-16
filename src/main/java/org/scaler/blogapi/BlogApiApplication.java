package org.scaler.blogapi;

import org.modelmapper.ModelMapper;
import org.scaler.blogapi.security.JWTTokenService;
import org.scaler.blogapi.security.TokenService;
import org.scaler.blogapi.tokens.UserTokenRepository;
import org.scaler.blogapi.tokens.UserTokenService;
import org.scaler.blogapi.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

	private final static String TOKEN_SERVICE_TYPE = "SST";

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
	public TokenService tokenService(
			@Autowired UserTokenRepository userTokenRepository,
			@Autowired UsersRepository usersRepository
	){
		switch (TOKEN_SERVICE_TYPE){
			case "SST":
				return new UserTokenService(userTokenRepository,usersRepository);
			case "JWT":
				return new JWTTokenService();
			default:
				throw new IllegalStateException("Unexpected value: " + TOKEN_SERVICE_TYPE);

		}
	}


}
