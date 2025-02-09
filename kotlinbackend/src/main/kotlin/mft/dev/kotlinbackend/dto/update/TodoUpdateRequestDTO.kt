package mft.dev.kotlinbackend.dto.update

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoUpdateRequestDTO(
    @JsonProperty("titolo")
    val titolo: String?,
    @JsonProperty("descrizione")
    val descrizione: String?
)
