package mft.dev.kotlinbackend.repository

import mft.dev.kotlinbackend.model.Utente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UtenteRepository : JpaRepository<Utente, Long> {
}