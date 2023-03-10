package com.cmv.caseproject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	private final JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider, JwtAuthenticationEntryPoint authenticationEntryPoint) {
		this.jwtAuthFilter = jwtAuthFilter;
		this.authenticationProvider = authenticationProvider;
		this.authenticationEntryPoint = authenticationEntryPoint;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.cors()
		.and()
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/api/v1/admin/login*")
		.permitAll()
		.requestMatchers(HttpMethod.GET ,"/api/v1/announcement/**")
		.permitAll()
		.requestMatchers(HttpMethod.GET ,"/api/v1/news/**")
		.permitAll()
		.requestMatchers(HttpMethod.GET ,"/announcement-photos/**")
		.permitAll()
		.requestMatchers(HttpMethod.GET ,"/notify/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint)
        .and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless since we use JWT token 
		.and()
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		
	    return http.build();
	}
}
