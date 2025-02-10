package mft.dev.javabackend.controller;

import mft.dev.javabackend.dto.insert.request.TodoInsertRequestDTO;
import mft.dev.javabackend.dto.insert.response.TodoResponseDTO;
import mft.dev.javabackend.dto.update.TodoUpdateRequestDTO;
import mft.dev.javabackend.model.Todo;
import mft.dev.javabackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> getTodo(@PathVariable("id") String id){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Todo todoFound = this.todoService.getTodo(idConverted);

            return new ResponseEntity<>(TodoResponseDTO.fromTodo(todoFound), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/utente/{id}")
    public ResponseEntity<List<TodoResponseDTO>> getUtenteTodos(@PathVariable("id") String id){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            List<Todo> todos = this.todoService.getTodosByUtenteId(idConverted);

            List<TodoResponseDTO> dto = todos.stream().map(TodoResponseDTO::fromTodo).toList();

            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> insertTodo(@PathVariable("id") String id, @RequestBody TodoInsertRequestDTO dto){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Todo newTodo = this.todoService.insertTodo(idConverted, dto);

            return new ResponseEntity<>(TodoResponseDTO.fromTodo(newTodo), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/molti/{id}")
    public ResponseEntity<List<TodoResponseDTO>> insertMoltiTodo(@PathVariable("id") String id, @RequestBody List<TodoInsertRequestDTO> dto){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            List<Todo> newTodos = this.todoService.insertMoltiTodo(idConverted, dto);

            List<TodoResponseDTO> responseDto = newTodos.stream().map(TodoResponseDTO::fromTodo).toList();

            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> updateTodo(@PathVariable("id") String id, @RequestBody TodoUpdateRequestDTO dto){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Todo todoUpdated = this.todoService.updateTodo(idConverted, dto);

            return new ResponseEntity<>(TodoResponseDTO.fromTodo(todoUpdated), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") String id){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            this.todoService.deleteTodo(idConverted);

            return new ResponseEntity<>("Todo eliminato con successo!", HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/utente/{id}")
    public ResponseEntity<String> deleteAllTodosByUtente(@PathVariable("id") String id){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            this.todoService.deleteAllTodoByUtenteId(idConverted);

            return new ResponseEntity<>("Todos eliminati con successo!", HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
