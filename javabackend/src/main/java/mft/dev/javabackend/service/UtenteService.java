package mft.dev.javabackend.service;

import mft.dev.javabackend.dto.insert.request.UtenteInsertRequestDTO;
import mft.dev.javabackend.dto.update.UtenteUpdateRequestDTO;
import mft.dev.javabackend.model.Utente;

import java.util.List;

public interface UtenteService {

    List<Utente> getUtenti();

    Utente getUtente(long id);

    Utente insertUtente(UtenteInsertRequestDTO dto);

    Utente updateUtente(long id, UtenteUpdateRequestDTO dto);

    void deleteUtente(long id);
}
