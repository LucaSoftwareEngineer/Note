package com.example.easynotes.controllers;

import com.example.easynotes.dto.*;
import com.example.easynotes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotaController {

    @Autowired
    private NoteService noteService;

    @PostMapping("api/note/aggiungi")
    public ResponseEntity<AggiungiNotaResponse> aggiungiNota(@RequestBody AggiungiNotaRequest request) {
        try {
            return ResponseEntity.ok(noteService.aggiungiNota(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("api/note/elenco")
    public ResponseEntity<List<NotaResponse>> elencoNote() {
        try {
            return ResponseEntity.ok(noteService.elencoNote());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("api/note/modifica")
    public ResponseEntity<ModificaNotaResponse> modificaNota(@RequestBody ModificaNotaRequest request) {
        try {
            return ResponseEntity.ok(noteService.modificaNota(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("api/note/elimina/{id}")
    public ResponseEntity<EliminaNotaResponse> eliminaNota (@PathVariable("id") Long id) {
        EliminaNotaResponse response = noteService.eliminaNota(id);
        if (response.isEliminata()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

}
