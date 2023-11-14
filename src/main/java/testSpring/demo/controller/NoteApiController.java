package testSpring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testSpring.demo.model.Note;
import testSpring.demo.service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteApiController {
    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody Note note) {return noteService.save(note);}

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        return noteService.update(id, noteDetails);
    }
    @GetMapping
    public List<Note> getAllNotes() {return noteService.findAll();}

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {return noteService.findById(id);}

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {noteService.delete(id);}
}
