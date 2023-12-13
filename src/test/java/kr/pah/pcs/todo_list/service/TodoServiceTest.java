package kr.pah.pcs.todo_list.service;

import kr.pah.pcs.todo_list.domain.Todo;
import kr.pah.pcs.todo_list.dto.CreateTodoDto;
import kr.pah.pcs.todo_list.repository.TodoRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {

    private final TodoService todoService;
    private final TodoRepository todoRepository;

    @Autowired
    TodoServiceTest(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @BeforeEach
    public void before() {
        CreateTodoDto todo1 = CreateTodoDto.builder()
                .title("title1")
                .content("content1")
                .build();
        CreateTodoDto todo2 = CreateTodoDto.builder()
                .title("title2")
                .content("content2")
                .build();
        todoService.createTodo(todo1);
        todoService.createTodo(todo2);
    }
    

    @Test
    void findAll() {
        List<Todo> todos = todoService.findAll();
        assertThat(todos).hasSize(2);
    }

    @Test
    void createTodo() {
        CreateTodoDto createTodoDto = CreateTodoDto
                .builder()
                .title("createTitle")
                .content("createContent")
                .build();
        todoService.createTodo(createTodoDto);
        assertThat(todoService.findAll()).hasSize(3);
    }

    @Test
    void checkTodo() {
        Long id = todoRepository.findAll().get(0).getId();
        todoService.checkTodo(id);
        assertThat(todoRepository.findById(id).get().isChecked()).isTrue();
    }

    @Test
    void deleteTodo() {
        Long id = todoRepository.findAll().get(0).getId();
        todoService.deleteTodo(id);
        assertThatThrownBy(() -> todoRepository.findById(id).get())
                .isInstanceOf(NoSuchElementException.class);
    }
}