package com.robin.SpringSecEx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
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
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails userDetails1 = User.withDefaultPasswordEncoder().username("robin").password("pass").roles("USER").build();
//		UserDetails userDetails2 = User.withDefaultPasswordEncoder().username("rohan").password("pass").roles("USER").build();
//		
//		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
//	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(BCryptVersion.$2A,12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
}
