package com.eeerrorcode.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eeerrorcode.todo.dto.TodoListDto;
import com.eeerrorcode.todo.dto.TodoWriteDto;
import com.eeerrorcode.todo.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {
  private final TodoRepository repository;

  // 목록 조회
  public List<TodoListDto> list() {
    return repository.findAll().stream().map(TodoListDto::new).toList();
  }

  // 등록
  public void write(TodoWriteDto dto) {
    repository.save(dto.toEntity());
  }

  // 삭제
}
