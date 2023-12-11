package kr.pah.pcs.todo_list.service;

import kr.pah.pcs.todo_list.domain.Todo;
import kr.pah.pcs.todo_list.dto.CreateTodoDto;
import kr.pah.pcs.todo_list.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void createTodo(CreateTodoDto createTodoDto) {
        todoRepository.save(Todo.builder()
                        .title(createTodoDto.getTitle())
                        .content(createTodoDto.getContent())
                        .build());
    }
}
