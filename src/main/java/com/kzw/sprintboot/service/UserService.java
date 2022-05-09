package com.kzw.sprintboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kzw.sprintboot.controller.dto.UserRegistrationDto;
import com.kzw.sprintboot.model.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
