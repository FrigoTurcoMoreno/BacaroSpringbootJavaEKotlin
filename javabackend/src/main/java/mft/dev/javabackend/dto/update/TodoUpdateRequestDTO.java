package mft.dev.javabackend.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import mft.dev.javabackend.model.Todo;

public record TodoUpdateRequestDTO(
        @JsonProperty("titolo")
        String titolo,
        @JsonProperty("descrizione")
        String descrizione
) {

        public static Todo toTodo(TodoUpdateRequestDTO dto, Todo todo){
                Todo updatedTodo = todo;

                if (dto.titolo() != null) updatedTodo.setTitolo(dto.titolo());
                if (dto.descrizione() != null) updatedTodo.setDescrizione(dto.descrizione());

                return updatedTodo;
        }
}
