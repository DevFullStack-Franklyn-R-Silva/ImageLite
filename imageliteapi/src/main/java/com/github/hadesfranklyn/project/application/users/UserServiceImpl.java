package com.github.hadesfranklyn.project.application.users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.hadesfranklyn.project.application.jwt.JwtService;
import com.github.hadesfranklyn.project.domain.AccessToken;
import com.github.hadesfranklyn.project.domain.entity.User;
import com.github.hadesfranklyn.project.domain.exception.DuplicatedTupleException;
import com.github.hadesfranklyn.project.domain.service.UserService;
import com.github.hadesfranklyn.project.infra.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	@Override
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public User save(User user) {
		var possibleUser = getByEmail(user.getEmail());
		if (possibleUser != null) {
			throw new DuplicatedTupleException("User already exists!");
		}
		encoderPassword(user);
		return userRepository.save(user);
	}

	@Override
	public AccessToken authenticate(String email, String password) {
		var user = getByEmail(email);
		if (user == null) {
			return null;
		}

		boolean matches = passwordEncoder.matches(password, user.getPassword());

		if (matches) {
			return jwtService.generateToken(user);
		}

		return null;
	}

	private void encoderPassword(User user) {
		String rawPassword = user.getPassword();
		String encoderPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encoderPassword);
	}

}
