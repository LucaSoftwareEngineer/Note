package com.example.easynotes.services;

import com.example.easynotes.dto.AggiungiNotaRequest;
import com.example.easynotes.dto.AggiungiNotaResponse;
import com.example.easynotes.model.Note;
import com.example.easynotes.repositories.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AggiungiNotaResponse aggiungiNota(AggiungiNotaRequest request) {
        Note nota = modelMapper.map(request, Note.class);
        nota = noteRepository.save(nota);
        return modelMapper.map(nota, AggiungiNotaResponse.class);
    }

}
