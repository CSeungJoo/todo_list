package kr.pah.pcs.todo_list.service;

import kr.pah.pcs.todo_list.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
}
