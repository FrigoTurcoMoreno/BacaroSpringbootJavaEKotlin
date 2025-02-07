package mft.dev.javabackend.dto.insert;

import com.fasterxml.jackson.annotation.JsonProperty;
import mft.dev.javabackend.model.Todo;

public record TodoInsertRequestDTO(
        @JsonProperty(value = "titolo", required = true)
        String titolo,
        @JsonProperty("descrizione")
        String descrizione
) {
    public Todo toTodo(){
        Todo todo = new Todo();
        todo.setTitolo(this.titolo());
        todo.setDescrizione(this.descrizione());

        return todo;
    }
}
