package com.github.hadesfranklyn.project.users;

import org.springframework.stereotype.Component;

import com.github.hadesfranklyn.project.domain.entity.User;

@Component
public class UserMapper {

	public User mapToUser(UserDTO dto) {
		return User.builder()
				.email(dto.getEmail())
				.password(dto.getPassword())
				.build();
	}
}
