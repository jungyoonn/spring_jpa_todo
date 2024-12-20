package com.eeerrorcode.todo.dto;

import com.eeerrorcode.todo.domain.TodoEntity;

import lombok.*;

@Getter
@Setter
@ToString
public class TodoListDto {
  private Long id;
  private String task;
  private boolean done;

  public TodoListDto(TodoEntity entity) {
    this.id = entity.getId();
    this.task = entity.getTask();
    this.done = entity.isDone();
  }

  // dto -> entity
  public TodoEntity toEntity() {
    return TodoEntity.builder()
    .id(this.id)
    .task(this.task)
    .done(this.done)
    .build();
  }
}
