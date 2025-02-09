package mft.dev.kotlinbackend.service.implementation

import mft.dev.kotlinbackend.dto.insert.TodoInsertRequestDTO
import mft.dev.kotlinbackend.dto.update.TodoUpdateRequestDTO
import mft.dev.kotlinbackend.model.Todo
import mft.dev.kotlinbackend.model.Utente
import mft.dev.kotlinbackend.repository.TodoRepository
import mft.dev.kotlinbackend.service.TodoService
import mft.dev.kotlinbackend.service.UtenteService
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository,
    private val utenteService: UtenteService
) : TodoService {
    override fun getTodosByUtenteId(id: Long): MutableList<Todo> {
        val utente: Utente = this.utenteService.getUtente(id)

        return this.todoRepository.findByUtente(utente)
    }

    override fun getTodo(id: Long): Todo {
        return this.todoRepository.findById(id).orElseThrow()
    }

    override fun insertTodo(id: Long, dto: TodoInsertRequestDTO): Todo {
        val utenteFound: Utente = this.utenteService.getUtente(id)

        val todo: Todo = dto.toTodo(utenteFound)

        return this.todoRepository.save(todo)
    }

    override fun insertMoltiTodo(id: Long, dto: MutableList<TodoInsertRequestDTO>): MutableList<Todo> {
        val utenteFound: Utente = this.utenteService.getUtente(id)

        val todos: MutableList<Todo> = dto.map { it.toTodo(utenteFound) }.toMutableList()

        return this.todoRepository.saveAll(todos)
    }

    override fun updateTodo(id: Long, dto: TodoUpdateRequestDTO): Todo {
        val todoFound: Todo = this.getTodo(id)

        TodoUpdateRequestDTO.toTodo(dto, todoFound)

        return todoFound
    }

    override fun deleteTodo(id: Long) {
        val todoFound: Todo = this.getTodo(id)

        this.todoRepository.delete(todoFound)
    }

    override fun deleteAllTodoByUtenteId(id: Long) {
        val utenteFound: Utente = this.utenteService.getUtente(id)

        this.todoRepository.deleteByUtente(utenteFound)
    }
}