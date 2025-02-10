package mft.dev.javabackend.service.implementation;

import jakarta.transaction.Transactional;
import mft.dev.javabackend.dto.insert.request.TodoInsertRequestDTO;
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
    public Todo insertTodo(long id, TodoInsertRequestDTO dto) {
        Utente utenteFound = this.utenteService.getUtente(id);

        Todo newTodo = dto.toTodo(utenteFound);

        return this.todoRepository.save(newTodo);
    }

    @Override
    @Transactional
    public List<Todo> insertMoltiTodo(long id, List<TodoInsertRequestDTO> dto) {
        Utente utenteFound = this.utenteService.getUtente(id);

        List<Todo> newTodos = dto.stream()
                .map(t -> t.toTodo(utenteFound))
                .toList();

        return this.todoRepository.saveAll(newTodos);
    }

    @Override
    @Transactional
    public Todo updateTodo(long id, TodoUpdateRequestDTO dto) {
        Todo todoFound = this.getTodo(id);

        todoFound = TodoUpdateRequestDTO.toTodo(dto, todoFound);

        return this.todoRepository.save(todoFound);
    }

    @Override
    @Transactional
    public void deleteTodo(long id) {
        Todo todoFound = this.getTodo(id);

        this.todoRepository.delete(todoFound);
    }

    @Override
    @Transactional
    public void deleteAllTodoByUtenteId(long id) {
        Utente utente = this.utenteService.getUtente(id);

        this.todoRepository.deleteAllByUtente(utente);
    }
}
