package Repository

import Model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface NotesRepository : JpaRepository<Note, Long> {

}