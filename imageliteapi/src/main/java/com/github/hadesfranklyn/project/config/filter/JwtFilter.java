package com.github.hadesfranklyn.project.config.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.hadesfranklyn.project.application.jwt.InvalidTokenException;
import com.github.hadesfranklyn.project.application.jwt.JwtService;
import com.github.hadesfranklyn.project.domain.entity.User;
import com.github.hadesfranklyn.project.domain.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = getToken(request);

		if (token != null) {
			try {
				String email = jwtService.getEmailFromToken(token);
				User user = userService.getByEmail(email);
				setUserAsAuthenticated(user);
			}catch (InvalidTokenException e) {
				log.error("Token inválido: {}", e.getMessage());
			}catch (Exception e) {
				log.error("Error na validação do token: {}", e.getMessage());
			}
		}

		filterChain.doFilter(request, response);
	}

	private void setUserAsAuthenticated(User user) {
		UserDetails userDetails = org.springframework.security.core.userdetails.User
				.withUsername(user.getEmail())
				.password(user.getPassword())
				.roles("USER")
				.build();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, "",
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getToken(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null) {
			String[] authHeaderParts = authHeader.split(" ");
			if (authHeaderParts.length == 2) {
				return authHeaderParts[1];
			}
		}
		return null;
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return request.getRequestURI().contains("/v1/users");
	}
}
