package mft.dev.javabackend.repository;

import mft.dev.javabackend.model.Todo;
import mft.dev.javabackend.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUtente(Utente utente);

    void deleteAllByUtente(Utente utente);
}
