package mft.dev.javabackend.service;

import mft.dev.javabackend.dto.insert.TodoInsertRequestDTO;
import mft.dev.javabackend.dto.update.TodoUpdateRequestDTO;
import mft.dev.javabackend.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getTodosByUtenteId(long id);

    Todo getTodo(long id);

    Todo insertTodo(long id, TodoInsertRequestDTO todo);

    List<Todo> insertMoltiTodo(long id, List<TodoInsertRequestDTO> todo);

    Todo updateTodo(long id, TodoUpdateRequestDTO todo);

    void deleteTodo(long id);

    void deleteAllTodoByUtenteId(long id);
}
