package com.github.hadesfranklyn.project.jwt;

import org.springframework.stereotype.Service;

import com.github.hadesfranklyn.project.domain.AccessToken;
import com.github.hadesfranklyn.project.domain.entity.User;

@Service
public class JwtService {

	public AccessToken generateToken(User user) {
		return new AccessToken("");
	}
}
