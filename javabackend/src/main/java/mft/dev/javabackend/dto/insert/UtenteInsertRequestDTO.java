package mft.dev.javabackend.dto.insert;

import com.fasterxml.jackson.annotation.JsonProperty;
import mft.dev.javabackend.model.Todo;
import mft.dev.javabackend.model.Utente;

import java.util.ArrayList;
import java.util.List;

public record UtenteInsertRequestDTO(
        @JsonProperty(value = "nome", required = true)
        String nome,
        @JsonProperty(value = "cognome", required = true)
        String cognome,
        @JsonProperty("email")
        String email,
        @JsonProperty("todos")
        List<TodoInsertRequestDTO> todosDto
) {
        public Utente toUtente(){
                Utente utente = new Utente();
                utente.setNome(this.nome());
                utente.setCognome(this.cognome());
                utente.setEmail(this.email());

                List<Todo> todos = todosDto() != null ? todosDto().stream().map(t -> t.toTodo(utente)).toList() : new ArrayList<>();
                utente.setTodoList(todos);

                return utente;
        }
}
