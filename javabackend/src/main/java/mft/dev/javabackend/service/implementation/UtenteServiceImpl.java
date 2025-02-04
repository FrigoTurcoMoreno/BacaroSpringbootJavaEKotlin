package mft.dev.javabackend.service.implementation;

import mft.dev.javabackend.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl {

    @Autowired
    private UtenteRepository utenteRepository;
}
