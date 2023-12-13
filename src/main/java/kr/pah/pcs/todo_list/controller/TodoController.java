package kr.pah.pcs.todo_list.controller;

import kr.pah.pcs.todo_list.common.Result;
import kr.pah.pcs.todo_list.domain.Todo;
import kr.pah.pcs.todo_list.dto.CreateTodoDto;
import kr.pah.pcs.todo_list.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    public final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<?> getTodos() {
        return ResponseEntity.ok(new Result<List<Todo>>(todoService.findAll()));
    }

    @PostMapping("/create-todo")
    public ResponseEntity<?> createTodo(@RequestBody CreateTodoDto createTodoDto) {
        todoService.createTodo(createTodoDto);
        return ResponseEntity.ok(new Result<String>("성공적으로 TODO가 등록되었습니다."));
    }

    @PutMapping("/check-todo/{id}")
    public ResponseEntity<?> checkTodo(@PathVariable("id") Long id) {
        todoService.checkTodo(id);
        return ResponseEntity.ok(new Result<String>("성공적으로 TODO의 상태가 변경되었습니다."));
    }

    @DeleteMapping("/delete-todo/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok(new Result<String>("성공적으로 TODO가 삭제되었습니다."));
    }
}
