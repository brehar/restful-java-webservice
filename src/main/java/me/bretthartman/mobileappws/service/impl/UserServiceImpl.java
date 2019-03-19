package me.bretthartman.mobileappws.service.impl;

import me.bretthartman.mobileappws.UserRepository;
import me.bretthartman.mobileappws.io.entity.UserEntity;
import me.bretthartman.mobileappws.service.UserService;
import me.bretthartman.mobileappws.shared.Utils;
import me.bretthartman.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final Utils utils;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserServiceImpl(
      @Autowired UserRepository userRepository,
      @Autowired Utils utils,
      @Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.utils = utils;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public UserDto createUser(UserDto user) {
    if (userRepository.findByEmail(user.getEmail()) != null)
      throw new RuntimeException("Record already exists.");

    UserEntity userEntity = new UserEntity();

    BeanUtils.copyProperties(user, userEntity);

    String publicUserId = utils.generateUserId(30);
    userEntity.setUserId(publicUserId);
    userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

    UserEntity storedUserDetails = userRepository.save(userEntity);
    UserDto returnValue = new UserDto();

    BeanUtils.copyProperties(storedUserDetails, returnValue);

    return returnValue;
  }
}
