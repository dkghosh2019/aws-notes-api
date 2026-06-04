package com.dipak.awsnotesapi.service;

import com.dipak.awsnotesapi.dto.NoteRequestDto;
import com.dipak.awsnotesapi.dto.NoteResponseDto;
import com.dipak.awsnotesapi.entity.Note;
import com.dipak.awsnotesapi.exception.ResourceNotFoundException;
import com.dipak.awsnotesapi.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteResponseDto createNote(NoteRequestDto requestDto) {
        Note note = Note.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .build();

        Note savedNote = noteRepository.save(note);

        return mapToResponseDto(savedNote);
    }

    public List<NoteResponseDto> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }

    public NoteResponseDto getNoteById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));

        return mapToResponseDto(note);
    }

    public NoteResponseDto updateNote(Long id, NoteRequestDto requestDto) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id: " + id));

        note.setTitle(requestDto.getTitle());
        note.setContent(requestDto.getContent());

        Note updatedNote = noteRepository.save(note);

        return mapToResponseDto(updatedNote);
    }

    public void deleteNote(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Note not found with id: " + id);
        }

        noteRepository.deleteById(id);
    }

    private NoteResponseDto mapToResponseDto(Note note) {
        return NoteResponseDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }
}