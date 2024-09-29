package com.example.practices.streams;

import com.example.core.dto.UserDto;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IStreamPracticeService {
  List<UserDto> usersNameAndSurnameToUpperCase();

  List<UserDto> convertAndSwapFirstLastChar(String letter);

  List<UserDto> filterUsersByEmailDomain(String domain);

  List<UserDto> filterUsersByOldCreateDate();

  Map<Integer, List<UserDto>> groupUsersByNameLength();

  List<UserDto> filterUsersWithoutEmail();

  List<UserDto> sortUsersByName();

  Optional<UserDto> findUserWithLongestName();
}
