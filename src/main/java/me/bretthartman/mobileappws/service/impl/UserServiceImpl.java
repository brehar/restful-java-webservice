package me.bretthartman.mobileappws.service.impl;

import me.bretthartman.mobileappws.UserRepository;
import me.bretthartman.mobileappws.io.entity.UserEntity;
import me.bretthartman.mobileappws.service.UserService;
import me.bretthartman.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(@Autowired UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDto createUser(UserDto user) {
    UserEntity userEntity = new UserEntity();

    BeanUtils.copyProperties(user, userEntity);
    userEntity.setUserId("aFalsisExsul"); // TODO: Remove this.
    userEntity.setEncryptedPassword("Genetrixs sunt lubas de raptus racana.");  // TODO: Remove this.

    UserEntity storedUserDetails = userRepository.save(userEntity);
    UserDto returnValue = new UserDto();

    BeanUtils.copyProperties(storedUserDetails, returnValue);

    return returnValue;
  }
}
