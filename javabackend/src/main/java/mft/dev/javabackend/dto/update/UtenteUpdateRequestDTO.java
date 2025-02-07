package mft.dev.javabackend.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import mft.dev.javabackend.model.Utente;

public record UtenteUpdateRequestDTO(
        @JsonProperty("nome")
        String nome,
        @JsonProperty("cognome")
        String cognome,
        @JsonProperty("email")
        String email
) {

        public static Utente toUtente(UtenteUpdateRequestDTO dto, Utente utente){
                Utente updatedUtente = utente;

                if (dto.nome() != null) updatedUtente.setNome(dto.nome());
                if (dto.cognome() != null) updatedUtente.setCognome(dto.cognome());
                if (dto.email() != null && !dto.email().isBlank()) updatedUtente.setEmail(dto.email());

                return updatedUtente;
        }
}
