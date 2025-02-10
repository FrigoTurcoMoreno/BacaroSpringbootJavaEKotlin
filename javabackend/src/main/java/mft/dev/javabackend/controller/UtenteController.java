package mft.dev.javabackend.controller;

import mft.dev.javabackend.dto.insert.request.UtenteInsertRequestDTO;
import mft.dev.javabackend.dto.insert.response.UtenteResponseDTO;
import mft.dev.javabackend.dto.update.UtenteUpdateRequestDTO;
import mft.dev.javabackend.model.Utente;
import mft.dev.javabackend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public ResponseEntity<List<UtenteResponseDTO>> getAllUtenti(){
        List<UtenteResponseDTO> utenti = this.utenteService.getUtenti().stream().map(UtenteResponseDTO::fromUtente).toList();

        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtenteResponseDTO> getUtente(@PathVariable("id") String id){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Utente utenteFound = this.utenteService.getUtente(idConverted);

            return new ResponseEntity<>(UtenteResponseDTO.fromUtente(utenteFound), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UtenteResponseDTO> insertUtente(@RequestBody UtenteInsertRequestDTO dto){
        Utente newUtente = this.utenteService.insertUtente(dto);

        return new ResponseEntity<>(UtenteResponseDTO.fromUtente(newUtente), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtenteResponseDTO> updateUtente(@PathVariable("id") String id, @RequestBody UtenteUpdateRequestDTO dto){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try{
            Utente utenteUpdated = this.utenteService.updateUtente(idConverted, dto);

            return new ResponseEntity<>(UtenteResponseDTO.fromUtente(utenteUpdated), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUtente(@PathVariable("id") String id){
        long idConverted;

        try {
            idConverted = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            this.utenteService.deleteUtente(idConverted);

            return new ResponseEntity<>("Utente eliminato con successo!", HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
