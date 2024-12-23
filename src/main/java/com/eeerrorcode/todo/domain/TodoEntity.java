package com.eeerrorcode.todo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "todo")
@Table(name = "tbl_todo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String task;
  private boolean done;
}
