package com.example.core.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user", schema = "practices")
@Getter
@Setter
public class User {
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
  @SequenceGenerator(name = "seq_user", sequenceName = "practices.SEQ_USER", allocationSize = 1)
  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surName;

  @Column(name = "email")
  private String email;

  @Column(name = "create_date")
  private LocalDate createDate;
}
