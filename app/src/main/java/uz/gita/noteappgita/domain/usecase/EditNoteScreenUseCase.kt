package uz.gita.noteappgita.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteappgita.data.model.NoteData

interface EditNoteScreenUseCase {
    fun updateNote(noteData: NoteData): Flow<Unit>
    fun deleteNote(noteData: NoteData): Flow<Unit>
}