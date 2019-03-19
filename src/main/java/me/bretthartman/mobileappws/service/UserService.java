package me.bretthartman.mobileappws.service;

import me.bretthartman.mobileappws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  UserDto createUser(UserDto user);
}
