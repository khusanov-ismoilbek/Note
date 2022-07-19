package uz.gita.noteappgita.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteappgita.data.model.NoteData

interface NotePageUseCase {
    fun getAllNotes(): Flow<List<NoteData>>
}