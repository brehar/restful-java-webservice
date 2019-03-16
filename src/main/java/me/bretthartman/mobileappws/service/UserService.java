package me.bretthartman.mobileappws.service;

import me.bretthartman.mobileappws.shared.dto.UserDto;

public interface UserService {
  UserDto createUser(UserDto user);
}
