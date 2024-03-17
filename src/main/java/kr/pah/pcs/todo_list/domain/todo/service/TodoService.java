package kr.pah.pcs.todo_list.domain.todo.service;

import kr.pah.pcs.todo_list.domain.todo.domain.Todo;
import kr.pah.pcs.todo_list.domain.todo.dto.CreateTodoDto;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos();
    Todo getTodo(Long id);
    void createTodo(CreateTodoDto dto);
    void checkTodo(Long id);
    void deleteTodo(Long id);
}
