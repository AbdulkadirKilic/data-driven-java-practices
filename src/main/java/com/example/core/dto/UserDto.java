package com.example.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
  private Long id;
  private String name;
  private String surName;
  private String email;
  private LocalDate createDate;
}
