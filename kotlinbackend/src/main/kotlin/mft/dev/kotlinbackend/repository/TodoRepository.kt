package mft.dev.kotlinbackend.repository

import mft.dev.kotlinbackend.model.Todo
import mft.dev.kotlinbackend.model.Utente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {
    fun findByUtente(utente: Utente): MutableList<Todo>

    fun deleteByUtente(utente: Utente)
}