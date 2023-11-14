package testSpring.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import testSpring.demo.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
