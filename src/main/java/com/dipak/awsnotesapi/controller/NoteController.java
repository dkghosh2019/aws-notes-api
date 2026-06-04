package com.dipak.awsnotesapi.controller;

import com.dipak.awsnotesapi.dto.NoteRequestDto;
import com.dipak.awsnotesapi.dto.NoteResponseDto;
import com.dipak.awsnotesapi.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteResponseDto createNote(@Valid @RequestBody NoteRequestDto requestDto) {
        return noteService.createNote(requestDto);
    }

    @GetMapping
    public List<NoteResponseDto> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public NoteResponseDto getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("/{id}")
    public NoteResponseDto updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequestDto requestDto
    ) {
        return noteService.updateNote(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}