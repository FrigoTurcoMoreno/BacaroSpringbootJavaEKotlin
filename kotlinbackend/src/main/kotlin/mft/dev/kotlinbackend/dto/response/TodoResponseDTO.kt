package mft.dev.kotlinbackend.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import mft.dev.kotlinbackend.model.Todo

data class TodoResponseDTO(
    @JsonProperty(value = "id", required = true)
    val id: Long,
    @JsonProperty(value = "titolo", required = true)
    val titolo: String,
    @JsonProperty("descrizione")
    val descrizione: String?
) {
    companion object {
        fun fromTodo(todo: Todo): TodoResponseDTO {
            return TodoResponseDTO(
                todo.id!!,
                todo.titolo,
                todo.descrizione
            )
        }
    }
}
