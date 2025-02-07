package mft.dev.javabackend.service.implementation;

import jakarta.transaction.Transactional;
import mft.dev.javabackend.dto.insert.TodoInsertRequestDTO;
import mft.dev.javabackend.dto.update.TodoUpdateRequestDTO;
import mft.dev.javabackend.model.Todo;
import mft.dev.javabackend.model.Utente;
import mft.dev.javabackend.repository.TodoRepository;
import mft.dev.javabackend.service.TodoService;
import mft.dev.javabackend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UtenteService utenteService;

    @Override
    public List<Todo> getTodosByUtenteId(long id) {
        Utente utenteFound = this.utenteService.getUtente(id);

        return this.todoRepository.findByUtente(utenteFound);
    }

    @Override
    public Todo getTodo(long id) {
        return this.todoRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Todo insertTodo(long id, TodoInsertRequestDTO todo) {
        Utente utenteFound = this.utenteService.getUtente(id);

        Todo newTodo = todo.toTodo();
        newTodo.setUtente(utenteFound);

        return this.todoRepository.save(newTodo);
    }

    @Override
    @Transactional
    public List<Todo> insertMoltiTodo(long id, List<TodoInsertRequestDTO> todo) {
        Utente utenteFound = this.utenteService.getUtente(id);

        List<Todo> newTodos = todo.stream()
                .map(TodoInsertRequestDTO::toTodo)
                .peek(t -> {
                    t.setUtente(utenteFound);
                }).toList();

        return this.todoRepository.saveAll(newTodos);
    }

    @Override
    public Todo updateTodo(long id, TodoUpdateRequestDTO todo) {
        Todo todoFound = this.getTodo(id);

        todoFound = TodoUpdateRequestDTO.toTodo(todo, todoFound);

        return todoFound;
    }

    @Override
    public void deleteTodo(long id) {
        Todo todoFound = this.getTodo(id);

        this.todoRepository.delete(todoFound);
    }

    @Override
    public void deleteAllTodoByUtenteId(long id) {
        Utente utente = this.utenteService.getUtente(id);

        this.todoRepository.deleteAllByUtente(utente);
    }
}
