package com.example.core.controller;

import com.example.core.controller.request.CreateUserRequest;
import com.example.core.controller.response.CreateUserResponse;
import com.example.core.dto.UserDto;
import com.example.core.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  private final IUserService userService;

  @Autowired
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @PostMapping("/save")
  public ResponseEntity<CreateUserResponse> saveUser(
      @RequestBody CreateUserRequest createUserRequest) {
    return ResponseEntity.ok(userService.saveUser(createUserRequest));
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @DeleteMapping(path = "/{id}")
  public void deleteUserById(@PathVariable Long id) {
    userService.deleteUserById(id);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }
}
