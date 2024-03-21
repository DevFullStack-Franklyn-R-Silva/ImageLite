package com.github.hadesfranklyn.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.github.hadesfranklyn.project.application.jwt.JwtService;
import com.github.hadesfranklyn.project.config.filter.JwtFilter;
import com.github.hadesfranklyn.project.domain.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	JwtFilter jwtFilter(JwtService jwtService, UserService userService) {
		return new JwtFilter(jwtService, userService);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.cors(cors -> cors.configure(http))
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/v1/users/**").permitAll();
					auth.requestMatchers(HttpMethod.GET, "/v1/images/**").permitAll();
					auth.anyRequest().authenticated();
				})
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
		UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
		cors.registerCorsConfiguration("/**", config);
		return cors;
	}
}
