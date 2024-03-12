package com.github.hadesfranklyn.project.users;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.hadesfranklyn.project.domain.AccessToken;
import com.github.hadesfranklyn.project.domain.entity.User;
import com.github.hadesfranklyn.project.domain.exception.DuplicatedTupleException;
import com.github.hadesfranklyn.project.domain.service.UserService;
import com.github.hadesfranklyn.project.infra.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	final private UserRepository userRepository;

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
		return userRepository.save(user);
	}

	@Override
	public AccessToken authenticate(String email, String password) {
		return null;
	}

}
