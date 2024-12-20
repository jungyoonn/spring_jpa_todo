package com.eeerrorcode.todo.dto;

import com.eeerrorcode.todo.domain.TodoEntity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoWriteDto {
  private String task;

  public TodoWriteDto(TodoEntity entity) {
    this.task = entity.getTask();
  }

  // dto -> entity
  public TodoEntity toEntity() {
    return TodoEntity.builder()
    .task(this.task)
    .build();
  }
}
