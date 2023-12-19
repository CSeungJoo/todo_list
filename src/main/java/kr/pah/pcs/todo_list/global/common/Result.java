package kr.pah.pcs.todo_list.global.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    private T data;
    private boolean isError;

    public Result(T data) {
        this.data = data;
        this.isError = false;
    }
}
