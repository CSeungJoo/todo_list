package kr.pah.pcs.todo_list.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    @Id @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private boolean check;

    @Column(name = "create_date")
    private LocalDate createDate;
}
