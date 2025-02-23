package mft.dev.javabackend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import mft.dev.javabackend.model.Utente;

import java.util.List;

public record UtenteResponseDTO(
        @JsonProperty(value = "id", required = true)
        long id,
        @JsonProperty(value = "nome", required = true)
        String nome,
        @JsonProperty(value = "cognome", required = true)
        String cognome,
        @JsonProperty("email")
        String email,
        @JsonProperty("todos")
        List<TodoResponseDTO> todos
) {
    public static UtenteResponseDTO fromUtente(Utente utente){
        return new UtenteResponseDTO(
                utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getEmail(),
                utente.getTodoList().stream().map(TodoResponseDTO::fromTodo).toList()
        );
    }
}
