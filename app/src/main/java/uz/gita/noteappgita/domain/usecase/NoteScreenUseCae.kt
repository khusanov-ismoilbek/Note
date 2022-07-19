package uz.gita.noteappgita.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteappgita.data.model.NoteData

interface NoteScreenUseCae {
    fun insertNote(noteData: NoteData) : Flow<Unit>
}