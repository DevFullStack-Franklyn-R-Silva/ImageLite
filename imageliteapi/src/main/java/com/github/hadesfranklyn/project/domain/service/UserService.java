package com.github.hadesfranklyn.project.domain.service;

import com.github.hadesfranklyn.project.domain.AccessToken;
import com.github.hadesfranklyn.project.domain.entity.User;

public interface UserService {
	User getByEmail(String email);
	User save(User user);
	AccessToken authenticate(String email, String password);
}
