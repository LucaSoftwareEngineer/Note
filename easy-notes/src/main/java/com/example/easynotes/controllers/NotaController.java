package com.example.easynotes.controllers;

import com.example.easynotes.dto.AggiungiNotaRequest;
import com.example.easynotes.dto.AggiungiNotaResponse;
import com.example.easynotes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
