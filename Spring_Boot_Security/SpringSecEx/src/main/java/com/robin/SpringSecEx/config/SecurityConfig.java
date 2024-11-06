package com.robin.SpringSecEx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.websocket.Session;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//			
//			@Override
//			public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//				// TODO Auto-generated method stub
//				customizer.disable();
//			}
//		};
//		http.csrf(custCsrf);//To DISABLE CFRF Token the Long Way
		
//		 |
//		 |
//		reduceded to 
//		 |
//		 V
		
//		http.csrf(customizer -> customizer.disable());//To DISABLE CFRF Token the short way
//		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());//To Enable Authentication
//		http.formLogin(Customizer.withDefaults());//For Enabling FORM LOGIN THROUGH UI
//		http.httpBasic(Customizer.withDefaults());//For Enabling LOGIN THROUGH REST API IN POSTMAN
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //will generate new session ID
//		return http.build();
		
//		 |
//		 |
//		again reduceded to 
//		 |
//		 V
		
		return http.csrf(customizer -> customizer.disable()).
		authorizeHttpRequests(request -> request.anyRequest().authenticated()).
//		formLogin(Customizer.withDefaults()).
		httpBasic(Customizer.withDefaults()).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
		
	}
}
