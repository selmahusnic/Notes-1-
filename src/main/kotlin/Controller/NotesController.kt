package Controller

import Model.Note
import Repository.NotesRepository
import org.hibernate.validator.internal.util.privilegedactions.GetMethods
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestMapping



@RestController
@RequestMapping("/api")
    class NotesController(private val notesRepository: NotesRepository) {

        @GetMapping("/notes")
        fun getAllNotes(): List<Note> =
                notesRepository.findAll()


        @PostMapping("/notes")
        fun createNewNote(@Valid @RequestBody note: Note): Note =
                notesRepository.save(note)


        @GetMapping("/notes/{id}")
        fun getNoteById(@PathVariable(value = "id") noteId: Long): ResponseEntity<Note> {
            return notesRepository.findById(noteId).map { note ->
                ResponseEntity.ok(note)
            }.orElse(ResponseEntity.notFound().build())
        }

        @PutMapping("/notes/{id}")
        fun updateNoteById(@PathVariable(value = "id") noteId: Long,
                              @Valid @RequestBody newNote: Note): ResponseEntity<Note> {

            return notesRepository.findById(noteId).map { existingNote ->
                val updatedNote: Note = existingNote
                        .copy(title = newNote.title, content = newNote.content)
                ResponseEntity.ok().body(notesRepository.save(updatedNote))
            }.orElse(ResponseEntity.notFound().build())

        }

        @DeleteMapping("/notes/{id}")
        fun deleteNoteById(@PathVariable(value = "id") noteId: Long): ResponseEntity<Void> {

            return notesRepository.findById(noteId).map { note  ->
                notesRepository.delete(note)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

        }
}
