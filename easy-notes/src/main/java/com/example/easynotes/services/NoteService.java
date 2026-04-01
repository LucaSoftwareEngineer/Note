package com.example.easynotes.services;

import com.example.easynotes.dto.*;
import com.example.easynotes.exceptions.NotaNotFound;
import com.example.easynotes.model.Note;
import com.example.easynotes.repositories.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AggiungiNotaResponse aggiungiNota(AggiungiNotaRequest request) {
        if (request.getCreatedAt() == null) {
            Date createdAt = Date.valueOf(LocalDate.now());
            request.setCreatedAt(createdAt);
        }
        Note nota = modelMapper.map(request, Note.class);
        nota = noteRepository.save(nota);
        return modelMapper.map(nota, AggiungiNotaResponse.class);
    }

    public List<NotaResponse> elencoNote() {
        List<Note> note = noteRepository.findAll();
        Iterator iterator = note.listIterator();

        List<NotaResponse> noteResponse = new ArrayList<>();
        while (iterator.hasNext()) {
            NotaResponse notaResponse = modelMapper.map(iterator.next(), NotaResponse.class);
            noteResponse.add(notaResponse);
        }

        return noteResponse;
    }

    public ModificaNotaResponse modificaNota(ModificaNotaRequest request) throws NotaNotFound {

        Note nota = noteRepository.findById(request.getId()).get();
        if (nota == null) {
            throw  new NotaNotFound();
        }

        nota.setTitle(request.getTitle());
        nota.setContent(request.getContent());
        nota.setCreatedAt(request.getCreatedAt());

        noteRepository.save(nota);

        return modelMapper.map(nota, ModificaNotaResponse.class);
    }

}
