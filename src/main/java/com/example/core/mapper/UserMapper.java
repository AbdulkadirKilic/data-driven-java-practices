package com.example.core.mapper;

import com.example.core.dto.UserDto;
import com.example.core.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDto userToUserDto(User user);

  User userDtoToUser(UserDto userDto);
}
