package testSpring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import testSpring.demo.model.Note;
import testSpring.demo.service.NoteService;

import java.util.List;

@Controller
@RequestMapping("/")
public class NoteWebController {
    private final NoteService noteService;

    @Autowired
    public NoteWebController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String viewNotesPage(Model model) {
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes", notes);
        return "notes";
    }
}
