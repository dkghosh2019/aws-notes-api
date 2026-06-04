package com.dipak.awsnotesapi.controller;

import com.dipak.awsnotesapi.dto.NoteRequestDto;
import com.dipak.awsnotesapi.dto.NoteResponseDto;
import com.dipak.awsnotesapi.service.NoteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor

@Tag(
        name = "Notes API",
        description = "CRUD APIs for managing notes"
)
public class NoteController {

    private final NoteService noteService;

    @Operation(summary = "Create a new note")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteResponseDto createNote(
            @Valid @RequestBody NoteRequestDto requestDto
    ) {
        return noteService.createNote(requestDto);
    }

    @Operation(summary = "Get all notes")
    @GetMapping
    public List<NoteResponseDto> getAllNotes() {
        return noteService.getAllNotes();
    }

    @Operation(summary = "Get note by ID")
    @GetMapping("/{id}")
    public NoteResponseDto getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @Operation(summary = "Update note by ID")
    @PutMapping("/{id}")
    public NoteResponseDto updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequestDto requestDto
    ) {
        return noteService.updateNote(id, requestDto);
    }

    @Operation(summary = "Delete note by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}