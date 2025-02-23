package mft.dev.kotlinbackend.controller

import mft.dev.kotlinbackend.dto.insert.UtenteInsertRequestDTO
import mft.dev.kotlinbackend.dto.response.TodoResponseDTO
import mft.dev.kotlinbackend.dto.response.UtenteResponseDTO
import mft.dev.kotlinbackend.dto.update.UtenteUpdateRequestDTO
import mft.dev.kotlinbackend.model.Todo
import mft.dev.kotlinbackend.model.Utente
import mft.dev.kotlinbackend.service.UtenteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/utenti")
class UtenteController @Autowired constructor(
    val utenteService: UtenteService
) {

    @GetMapping
    fun getAllUtenti(): ResponseEntity<MutableList<UtenteResponseDTO>> {
        val utenti: MutableList<Utente> = this.utenteService.getUtenti()

        return ResponseEntity(utenti.stream().map { UtenteResponseDTO.fromUtente(it) }.toList(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getUtente(@PathVariable("id") id: String): ResponseEntity<UtenteResponseDTO> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            val utenteFound: Utente = this.utenteService.getUtente(idConverted)

            return ResponseEntity(UtenteResponseDTO.fromUtente(utenteFound), HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }

    @PostMapping
    fun insertUtente(@RequestBody dto: UtenteInsertRequestDTO): ResponseEntity<UtenteResponseDTO> {
        val newUtente: Utente = this.utenteService.insertUtente(dto)

        return ResponseEntity(UtenteResponseDTO.fromUtente(newUtente), HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateUtente(@PathVariable("id") id: String, @RequestBody dto: UtenteUpdateRequestDTO): ResponseEntity<UtenteResponseDTO> {
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            val utenteFound: Utente = this.utenteService.updateUtente(idConverted, dto)

            return ResponseEntity(UtenteResponseDTO.fromUtente(utenteFound), HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUtente(@PathVariable("id") id: String): ResponseEntity<String>{
        val idConverted: Long

        try {
            idConverted = id.toLong()
        } catch (ex: NumberFormatException) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }

        try {
            this.utenteService.deleteUtente(idConverted)

            return ResponseEntity("Utente eliminato con successo!", HttpStatus.OK)
        } catch (ex: NoSuchElementException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}