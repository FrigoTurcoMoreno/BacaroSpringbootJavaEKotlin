package mft.dev.javabackend.dto.insert.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import mft.dev.javabackend.model.Todo;

public record TodoResponseDTO(
        @JsonProperty(value = "id", required = true)
        long id,
        @JsonProperty(value = "titolo", required = true)
        String titolo,
        @JsonProperty("descrizione")
        String descrizione
) {

    public static TodoResponseDTO fromTodo(Todo todo){
        return new TodoResponseDTO(
                todo.getId(),
                todo.getTitolo(),
                todo.getDescrizione()
        );
    }
}
