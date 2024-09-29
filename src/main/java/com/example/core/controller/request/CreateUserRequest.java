package com.example.core.controller.request;

import com.example.core.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
  private UserDto userDTO;
}
