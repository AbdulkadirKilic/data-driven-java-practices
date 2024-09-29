package com.example.core.service;

import com.example.core.controller.request.CreateUserRequest;
import com.example.core.controller.response.CreateUserResponse;
import com.example.core.dto.UserDto;
import java.util.List;

public interface IUserService {
  CreateUserResponse saveUser(CreateUserRequest createUserRequest);

  List<UserDto> getAllUsers();

  UserDto getUserById(Long id);

  void deleteUserById(Long id);
}
