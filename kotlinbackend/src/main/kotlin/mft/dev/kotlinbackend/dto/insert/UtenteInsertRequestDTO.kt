package mft.dev.kotlinbackend.dto.insert

import com.fasterxml.jackson.annotation.JsonProperty
import mft.dev.kotlinbackend.model.Todo
import mft.dev.kotlinbackend.model.Utente

data class UtenteInsertRequestDTO(
    @JsonProperty("nome", required = true)
    val nome: String,
    @JsonProperty("cognome", required = true)
    val cognome: String,
    @JsonProperty("email")
    val email: String? = null,
    @JsonProperty("todos")
    val todosDto: MutableList<TodoInsertRequestDTO>?
) {
    companion object{

    }

    fun toUtente(): Utente{
        val utente = Utente(nome = nome, cognome = cognome, email = email)
        val todos: MutableList<Todo> = todosDto?.map{it.toTodo(utente)}?.toMutableList() ?: mutableListOf()
        utente.todoList = todos

        return utente
    }
}
