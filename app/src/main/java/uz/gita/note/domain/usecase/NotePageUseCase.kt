package uz.gita.note.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.note.data.model.NoteData

interface NotePageUseCase {
    fun getAllNotes(): Flow<List<NoteData>>
}