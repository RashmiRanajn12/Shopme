package com.shopme.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebsecurityConfig {
	@Bean
	SecurityFilterChain configureHttpSecurity(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests(auth-> auth.anyRequest().permitAll());
		return security.build();
			
	}
	@Bean
       PasswordEncoder  PasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
