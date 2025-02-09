package mft.dev.kotlinbackend.dto.update

import com.fasterxml.jackson.annotation.JsonProperty
import mft.dev.kotlinbackend.model.Todo

data class TodoUpdateRequestDTO(
    @JsonProperty("titolo")
    val titolo: String?,
    @JsonProperty("descrizione")
    val descrizione: String?
) {
    companion object {
        fun toTodo(dto: TodoUpdateRequestDTO, todo: Todo): Todo{
            dto.titolo?.let { todo.titolo = dto.titolo}
            dto.descrizione?.let { todo.descrizione = dto.descrizione }

            return todo
        }
    }
}
