package kr.pah.pcs.todo_list.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column(nullable = false)
    private boolean isChecked;

    @Column(name = "create_date")
    private LocalDate createDate;

    @PrePersist
    public void createTodoBefore() {
        createDate = LocalDate.now();
        isChecked = false;
    }
    public void modifiedCheck() {
        isChecked = !isChecked;
    }
}
