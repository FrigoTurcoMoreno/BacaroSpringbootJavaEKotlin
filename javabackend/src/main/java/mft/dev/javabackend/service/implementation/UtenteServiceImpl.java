package mft.dev.javabackend.service.implementation;

import jakarta.transaction.Transactional;
import mft.dev.javabackend.dto.insert.request.UtenteInsertRequestDTO;
import mft.dev.javabackend.dto.update.UtenteUpdateRequestDTO;
import mft.dev.javabackend.model.Utente;
import mft.dev.javabackend.repository.UtenteRepository;
import mft.dev.javabackend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public List<Utente> getUtenti() {
        return this.utenteRepository.findAll();
    }

    @Override
    public Utente getUtente(long id) {
        return this.utenteRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Utente insertUtente(UtenteInsertRequestDTO dto) {
        return this.utenteRepository.save(dto.toUtente());
    }

    @Override
    @Transactional
    public Utente updateUtente(long id, UtenteUpdateRequestDTO dto) {
        Utente utenteFound = this.getUtente(id);

        utenteFound = UtenteUpdateRequestDTO.toUtente(dto, utenteFound);

        return this.utenteRepository.save(utenteFound);
    }

    @Override
    @Transactional
    public void deleteUtente(long id) {
        Utente utenteFound = this.getUtente(id);

        this.utenteRepository.delete(utenteFound);
    }
}
