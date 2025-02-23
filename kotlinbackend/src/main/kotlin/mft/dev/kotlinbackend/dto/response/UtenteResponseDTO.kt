package mft.dev.kotlinbackend.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import mft.dev.kotlinbackend.model.Utente

data class UtenteResponseDTO(
    @JsonProperty(value = "id", required = true)
    val id: Long,
    @JsonProperty(value = "nome", required = true)
    val nome: String,
    @JsonProperty(value = "cognome", required = true)
    val cognome: String,
    @JsonProperty("email")
    val email: String?,
    @JsonProperty("todos")
    val todos: MutableList<TodoResponseDTO>
) {
    companion object {
        fun fromUtente(utente: Utente): UtenteResponseDTO {
            return UtenteResponseDTO(
                utente.id!!,
                utente.nome,
                utente.cognome,
                utente.email,
                utente.todoList.map { TodoResponseDTO.fromTodo(it) }.toMutableList()
            )
        }
    }
}
