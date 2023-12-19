package kr.pah.pcs.todo_list.domain.todo.service;

import kr.pah.pcs.todo_list.domain.todo.domain.Todo;
import kr.pah.pcs.todo_list.domain.todo.dto.CreateTodoDto;
import kr.pah.pcs.todo_list.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Transactional
    public void createTodo(CreateTodoDto createTodoDto) {
        todoRepository.save(Todo.builder()
                        .title(createTodoDto.getTitle())
                        .content(createTodoDto.getContent())
                        .build());
    }

    @Transactional
    public void checkTodo(Long id) {
        Todo todo = todoRepository.findById(id).get();
        todo.modifiedCheck();
        todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.delete(todoRepository.findById(id).get());
    }
}
