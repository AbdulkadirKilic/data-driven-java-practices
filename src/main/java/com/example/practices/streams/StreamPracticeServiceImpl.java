package com.example.practices.streams;

import com.example.core.dto.UserDto;
import com.example.core.service.IUserService;
import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamPracticeServiceImpl implements IStreamPracticeService {

  private final IUserService userService;
  private List<UserDto> userList;

  @Autowired
  public StreamPracticeServiceImpl(IUserService userService) {
    this.userService = userService;
  }

  @PostConstruct
  public void init() {
    this.userList = userService.getAllUsers();
  }

  public List<UserDto> usersNameAndSurnameToUpperCase() {

    return userList.stream()
        .map(
            userDto -> {
              userDto.setName(userDto.getName().toUpperCase());
              userDto.setSurName(userDto.getSurName().toUpperCase());
              return userDto;
            })
        .toList();
  }

  public List<UserDto> convertAndSwapFirstLastChar(String letter) {
    List<UserDto> filteredList =
        userList.stream()
            .filter(
                userDto ->
                    userDto != null
                        && userDto.getName().toUpperCase().startsWith(letter.toUpperCase()))
            .toList();

    return filteredList.stream().map((this::swapFirstAndLastChar)).toList();
  }

  private UserDto swapFirstAndLastChar(UserDto userDto) {
    UserDto newUserDto = new UserDto();
    newUserDto.setId(userDto.getId());
    newUserDto.setName(userDto.getName());
    newUserDto.setSurName(userDto.getSurName());
    newUserDto.setEmail(userDto.getEmail());
    newUserDto.setCreateDate(userDto.getCreateDate());
    StringBuilder sb = new StringBuilder(newUserDto.getName());

    char firstChar = Character.toLowerCase(newUserDto.getName().charAt(0));
    char lastChar =
        Character.toUpperCase(newUserDto.getName().charAt(newUserDto.getName().length() - 1));
    sb.setCharAt(0, lastChar);
    sb.setCharAt(newUserDto.getName().length() - 1, firstChar);
    newUserDto.setName(sb.toString());
    return newUserDto;
  }

  public List<UserDto> filterUsersByEmailDomain(String domain) {
    return userList.stream()
        .filter(userDto -> userDto.getEmail() != null && userDto.getEmail().endsWith(domain))
        .toList();
  }

  public List<UserDto> filterUsersByOldCreateDate() {
    LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
    return userList.stream()
        .filter(
            userDto ->
                userDto.getCreateDate() != null && userDto.getCreateDate().isBefore(thirtyDaysAgo))
        .toList();
  }

  public Map<Integer, List<UserDto>> groupUsersByNameLength() {
    return userList.stream().collect(Collectors.groupingBy(userDto -> userDto.getName().length()));
  }

  public List<UserDto> filterUsersWithoutEmail() {
    return userList.stream()
        .filter(userDto -> userDto.getEmail() == null || userDto.getEmail().isEmpty())
        .toList();
  }

  public List<UserDto> sortUsersByName() {
    return userList.stream().sorted(Comparator.comparing(UserDto::getName)).toList();
  }

  public Optional<UserDto> findUserWithLongestName() {
    return userList.stream().max(Comparator.comparingInt(userDto -> userDto.getName().length()));
  }
}
