package com.github.hadesfranklyn.project.application.jwt;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class SecretKeyGenerator {

	private SecretKey key;

	public SecretKey getKey() {
		if (key == null) {
			key = Jwts.SIG.HS256.key().build();
		}
		return key;
	}
}
