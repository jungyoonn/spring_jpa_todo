package com.eeerrorcode.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eeerrorcode.todo.domain.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
  
}
