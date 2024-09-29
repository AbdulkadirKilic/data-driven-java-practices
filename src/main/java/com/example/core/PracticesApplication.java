package com.example.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.core", "com.example.practices"})
public class PracticesApplication {

  public static void main(String[] args) {
    SpringApplication.run(PracticesApplication.class, args);
  }
}
