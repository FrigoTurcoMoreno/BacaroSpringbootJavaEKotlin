package mft.dev.kotlinbackend.service.implementation

import jakarta.transaction.Transactional
import mft.dev.kotlinbackend.dto.insert.UtenteInsertRequestDTO
import mft.dev.kotlinbackend.dto.update.UtenteUpdateRequestDTO
import mft.dev.kotlinbackend.model.Utente
import mft.dev.kotlinbackend.repository.UtenteRepository
import mft.dev.kotlinbackend.service.UtenteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UtenteServiceImpl @Autowired constructor(
    val utenteRepository: UtenteRepository
) : UtenteService {
    override fun getUtenti(): List<Utente> {
        return this.utenteRepository.findAll()
    }

    override fun getUtente(id: Long): Utente {
        return this.utenteRepository.findById(id).orElseThrow()
    }

    @Transactional
    override fun insertUtente(dto: UtenteInsertRequestDTO): Utente {
        val utente: Utente = dto.toUtente()
        return this.utenteRepository.save(utente)
    }

    @Transactional
    override fun updateUtente(id: Long, dto: UtenteUpdateRequestDTO): Utente {
        var utenteFound: Utente = this.getUtente(id)

        utenteFound = UtenteUpdateRequestDTO.toUtente(dto, utenteFound)

        return this.utenteRepository.save(utenteFound)
    }

    @Transactional
    override fun deleteUtente(id: Long) {
        val utente: Utente = this.getUtente(id)

        this.utenteRepository.delete(utente)
    }

}