package com.shivPrakash.Note_Sharing_API.Notes.RestController;

import java.util.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.shivPrakash.Note_Sharing_API.Notes.Repository.NotesRepository;
import com.shivPrakash.Note_Sharing_API.Notes.bean.Note;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NotesRepository repo;
	@GetMapping("/all")
	public List<Note> getAllNotes() {
		return repo.findAll();
	}
    @GetMapping("/id/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = repo.findById(id);
        return note.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/title/{title}")
    public List<Note> getNotesByTitle(@PathVariable String title) {
        return repo.findByTitle(title);
    }

    @GetMapping("/department/{department}")
    public List<Note> getNotesByDepartment(@PathVariable String department) {
        return repo.findByDepartment(department);
    }

    @GetMapping("/field/{field}")
    public List<Note> getNotesByField(@PathVariable String field) {
        return repo.findByField(field);
    }

    @GetMapping("/owner/{owner}")
    public List<Note> getNotesByOwner(@PathVariable String owner) {
        return repo.findByOwner(owner);
    }
    @PostMapping("/add")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note createdNote = repo.save(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        try {
            Note updatedNote = repo.save(noteDetails);
            return ResponseEntity.ok(updatedNote);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        try {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

