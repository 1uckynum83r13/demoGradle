package testSpring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testSpring.demo.model.Note;
import testSpring.demo.repository.NoteRepository;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note save(Note note) {return noteRepository.save(note);}

    public Note findById(Long id) {return noteRepository.findById(id).orElse(null);}

    public void delete(Long id) {noteRepository.deleteById(id);}

    public List<Note> findAll() {return noteRepository.findAll();}

    public Note update(Long id, Note noteDetails) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());
            return noteRepository.save(note);
        }
        return null;
    }
}
