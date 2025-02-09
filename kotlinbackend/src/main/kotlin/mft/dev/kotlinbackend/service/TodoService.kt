package mft.dev.kotlinbackend.service

import mft.dev.kotlinbackend.dto.insert.TodoInsertRequestDTO
import mft.dev.kotlinbackend.dto.update.TodoUpdateRequestDTO
import mft.dev.kotlinbackend.model.Todo

interface TodoService {
    fun getTodosByUtenteId(id: Long): MutableList<Todo>

    fun getTodo(id: Long): Todo

    fun insertTodo(id: Long, dto: TodoInsertRequestDTO): Todo

    fun insertMoltiTodo(id: Long, dto: MutableList<TodoInsertRequestDTO>): MutableList<Todo>

    fun updateTodo(id: Long, dto: TodoUpdateRequestDTO): Todo

    fun deleteTodo(id: Long)

    fun deleteAllTodoByUtenteId(id: Long)
}