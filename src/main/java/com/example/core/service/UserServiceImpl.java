package com.example.core.service;

import com.example.core.controller.request.CreateUserRequest;
import com.example.core.controller.response.CreateUserResponse;
import com.example.core.dto.UserDto;
import com.example.core.mapper.UserMapper;
import com.example.core.model.User;
import com.example.core.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public CreateUserResponse saveUser(CreateUserRequest createUserRequest) {
    createUserRequest.getUserDTO().setCreateDate(LocalDate.now());
    CreateUserResponse createUserResponse = new CreateUserResponse();
    User newUser = userMapper.userDtoToUser(createUserRequest.getUserDTO());
    User savedUser = userRepository.save(newUser);
    createUserResponse.setUserDTO(userMapper.userToUserDto(savedUser));
    return createUserResponse;
  }

  @Override
  public List<UserDto> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(userMapper::userToUserDto).toList();
  }

  @Override
  public UserDto getUserById(Long id) {
    Optional<User> optional = userRepository.findById(id);
    return optional.map(userMapper::userToUserDto).orElse(null);
  }

  @Override
  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }
}
