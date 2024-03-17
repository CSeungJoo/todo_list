package kr.pah.pcs.todo_list.domain.todo.service;

import kr.pah.pcs.todo_list.domain.todo.domain.Todo;
import kr.pah.pcs.todo_list.domain.todo.dto.CreateTodoDto;
import kr.pah.pcs.todo_list.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodo(Long id) {
        Optional<Todo> optTodo = todoRepository.findById(id);

        optTodo.orElseThrow(() -> new IllegalStateException("존재하지 않는 투두입니다."));

        return optTodo.get();
    }

    @Override
    @Transactional
    public void createTodo(CreateTodoDto createTodoDto) {
        todoRepository.save(Todo.builder()
                        .title(createTodoDto.getTitle())
                        .content(createTodoDto.getContent())
                        .build());
    }

    @Override
    @Transactional
    public void checkTodo(Long id) {
        Optional<Todo> optTodo = todoRepository.findById(id);

        optTodo.orElseThrow(() -> new IllegalStateException("존재하지 않는 투두입니다."));

        Todo todo = optTodo.get();
        todo.modifiedCheck();
    }

    @Override
    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
