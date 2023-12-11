package kr.pah.pcs.todo_list.repository;

import kr.pah.pcs.todo_list.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
