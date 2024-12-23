package com.eeerrorcode.todo.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.eeerrorcode.todo.domain.TodoEntity;
import com.eeerrorcode.todo.dto.TodoListDto;
import com.eeerrorcode.todo.dto.TodoWriteDto;
import com.eeerrorcode.todo.repository.TodoRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {
  private final TodoRepository repository;
  private EntityManager manager;

  @PostConstruct
  public void init() {
    repository.saveAll(
      Stream.of(
        TodoEntity.builder().task("first").build(),
        TodoEntity.builder().task("second").build(),
        TodoEntity.builder().task("third").build()
      ).toList()
    );
  }

  // 목록 조회
  public List<TodoListDto> list() {
    // return repository.findAll(Sort.by(Direction.DESC, "id")).stream().map(TodoListDto::new).toList();
    // return repository.findByOrderByTaskDescIdAsc().stream().map(TodoListDto::new).toList();
    return repository.findAll(Sort.by(Order.desc("task"), Order.asc("id"))).stream().map(TodoListDto::new).toList();
  }

  // 등록
  public void write(TodoWriteDto dto) {
    repository.save(dto.toEntity());
  }

  // 삭제
  public void remove(Long id) {
    repository.deleteById(id);
  }

  // 수정
  @Transactional
  public void modify(Long id) {
    // Optional<TodoEntity> entity = repository.findById(id);
    // entity.ifPresent(e -> { e.setDone(true); repository.save(e); });

    // repository.save(TodoEntity.builder().id(id).done(true).task("null").build());
  
    repository.updateTodoDoneById(id);
  }

  @Transactional
  public void modify2(Long id) {
    manager.find(TodoEntity.class, id).setDone(true);
  }
}
