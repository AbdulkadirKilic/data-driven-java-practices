package com.example.practices.streams;

import com.example.core.dto.UserDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practices/streams")
public class StreamPracticeController {

  private final IStreamPracticeService streamPracticeService;

  @Autowired
  public StreamPracticeController(IStreamPracticeService streamPracticeService) {
    this.streamPracticeService = streamPracticeService;
  }

  @GetMapping("/usersNameAndSurnameToUpperCase")
  public List<UserDto> usersNameAndSurnameToUpperCase() {
    return streamPracticeService.usersNameAndSurnameToUpperCase();
  }

  @GetMapping("/convertAndSwapFirstLastChar")
  public List<UserDto> convertAndSwapFirstLastChar(@RequestParam String letter) {
    return streamPracticeService.convertAndSwapFirstLastChar(letter);
  }

  @GetMapping("/filterUsersByEmailDomain")
  public List<UserDto> filterUsersByEmailDomain(@RequestParam String domain) {
    return streamPracticeService.filterUsersByEmailDomain(domain);
  }

  @GetMapping("/filterUsersByOldCreateDate")
  public List<UserDto> filterUsersByOldCreateDate() {
    return streamPracticeService.filterUsersByOldCreateDate();
  }
}
