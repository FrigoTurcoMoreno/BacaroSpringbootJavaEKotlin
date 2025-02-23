package mft.dev.kotlinbackend.service

import mft.dev.kotlinbackend.dto.insert.UtenteInsertRequestDTO
import mft.dev.kotlinbackend.dto.update.UtenteUpdateRequestDTO
import mft.dev.kotlinbackend.model.Utente

interface UtenteService {
    fun getUtenti(): MutableList<Utente>

    fun getUtente(id: Long): Utente

    fun insertUtente(dto: UtenteInsertRequestDTO): Utente

    fun updateUtente(id: Long, dto: UtenteUpdateRequestDTO): Utente

    fun deleteUtente(id: Long)
}