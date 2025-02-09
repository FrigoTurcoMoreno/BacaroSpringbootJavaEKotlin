package mft.dev.kotlinbackend.dto.update

import com.fasterxml.jackson.annotation.JsonProperty
import mft.dev.kotlinbackend.model.Utente

data class UtenteUpdateRequestDTO(
    @JsonProperty("nome")
    val nome: String?,
    @JsonProperty("cognome")
    val cognome: String?,
    @JsonProperty("email")
    val email: String?
) {
    companion object{
        fun toUtente(dto: UtenteUpdateRequestDTO, utente: Utente): Utente{
            dto.nome?.let { utente.nome = it }
            dto.cognome?.let { utente.cognome = it }
            dto.email?.let { utente.email = it}

            return utente
        }
    }
}
