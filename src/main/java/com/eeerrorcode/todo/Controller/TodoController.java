package com.eeerrorcode.todo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eeerrorcode.todo.dto.TodoWriteDto;
import com.eeerrorcode.todo.service.TodoService;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Log4j2
public class TodoController {
  @Autowired
  private TodoService service;

  @GetMapping("todos")
  public String list(Model model) {
    model.addAttribute("todoList", service.list());
    return "todo-list";
  }

  @PostMapping("todos")
  public String write(TodoWriteDto dto) {
    log.info(dto);
    service.write(dto);
    return "redirect:todos";
  }
  
  @RequestMapping("todos/remove")
  public String remove(Long id) {
    log.info(id);
    service.remove(id);
    return "redirect:/todos";
  }
  
  @RequestMapping("todos/modify")
  public String modify(Long id) {
    log.info(id);
    service.modify(id);
    return "redirect:/todos";
  }
}
