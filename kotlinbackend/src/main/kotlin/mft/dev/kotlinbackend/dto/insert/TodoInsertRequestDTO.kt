package mft.dev.kotlinbackend.dto.insert

import com.fasterxml.jackson.annotation.JsonProperty
import mft.dev.kotlinbackend.model.Todo
import mft.dev.kotlinbackend.model.Utente

data class TodoInsertRequestDTO(
    @JsonProperty("titolo", required = true)
    val titolo: String,
    @JsonProperty("descrizione")
    val descrizione: String? = null
) {
    companion object{

    }

    fun toTodo(utente: Utente): Todo{
        return Todo(titolo = titolo, descrizione = descrizione, utente = utente)
    }
}
