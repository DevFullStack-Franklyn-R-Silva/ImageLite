package com.github.hadesfranklyn.project.application.users;

import org.springframework.stereotype.Component;

import com.github.hadesfranklyn.project.domain.entity.User;

@Component
public class UserMapper {

	  public User mapToUser(UserDTO dto){
	        return User.builder()
	                .email(dto.getEmail())
	                .name(dto.getName())
	                .password(dto.getPassword())
	                .build();
	    }
}
