package mft.dev.kotlinbackend.controller

import mft.dev.kotlinbackend.dto.insert.TodoInsertRequestDTO
import mft.dev.kotlinbackend.dto.response.TodoResponseDTO
import mft.dev.kotlinbackend.dto.update.TodoUpdateRequestDTO
import mft.dev.kotlinbackend.model.Todo
import mft.dev.kotlinbackend.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class TodoController @Autowired constructor(
    val todoService: TodoService
) {

    @GetMapping("/{id}")
    fun getTodo(@PathVariable("id") id: String): ResponseEntity<TodoResponseDTO> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            val todoFound: Todo = this.todoService.getTodo(idConverted)

            return ResponseEntity(TodoResponseDTO.fromTodo(todoFound), HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/utente/{id}")
    fun getUtenteTodo(@PathVariable("id") id: String): ResponseEntity<MutableList<TodoResponseDTO>> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            val todos: MutableList<Todo> = this.todoService.getTodosByUtenteId(idConverted)

            return ResponseEntity(todos.stream().map(TodoResponseDTO::fromTodo).toList(), HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/utente/{id}")
    fun insertTodo(@PathVariable("id") id: String, @RequestBody dto: TodoInsertRequestDTO): ResponseEntity<TodoResponseDTO> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            val newTodo: Todo = this.todoService.insertTodo(idConverted, dto)

            return ResponseEntity(TodoResponseDTO.fromTodo(newTodo), HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/utente/{id}/molti")
    fun insertMoltiTodo(@PathVariable("id") id: String, @RequestBody dto: MutableList<TodoInsertRequestDTO>): ResponseEntity<MutableList<TodoResponseDTO>> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            val newTodos: MutableList<Todo> = this.todoService.insertMoltiTodo(idConverted, dto)

            return ResponseEntity(newTodos.stream().map(TodoResponseDTO::fromTodo).toList(), HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable("id") id: String, @RequestBody dto: TodoUpdateRequestDTO): ResponseEntity<TodoResponseDTO> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            val todoFound: Todo = this.todoService.updateTodo(idConverted, dto)

            return ResponseEntity(TodoResponseDTO.fromTodo(todoFound), HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable("id") id: String): ResponseEntity<String> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            this.todoService.deleteTodo(idConverted)

            return ResponseEntity("Todo eliminato con successo!", HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/utente/{id}")
    fun deleteAllTodosByUtente(@PathVariable("id") id: String): ResponseEntity<String> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            this.todoService.deleteAllTodoByUtenteId(idConverted)

            return ResponseEntity("Todos eliminati con successo!", HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}