package uz.gita.noteappgita.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.data.sources.entity.NoteEntity
import uz.gita.noteappgita.domain.repository.AppRepository
import uz.gita.noteappgita.domain.usecase.EditNoteScreenUseCase
import javax.inject.Inject

class EditNoteScreenUseCaseImpl @Inject constructor(private val appRepository: AppRepository) :
    EditNoteScreenUseCase {
    override fun updateNote(noteData: NoteData): Flow<Unit> = flow {
        appRepository.updateNote(
            NoteEntity(
                noteData.id,
                noteData.title,
                noteData.note,
                noteData.time,
                noteData.isDeleted,
                noteData.isPinned
            )
        )
        emit(Unit)
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(noteData: NoteData): Flow<Unit> = flow {
        appRepository.deleteNote(
            NoteEntity(
                noteData.id,
                noteData.title,
                noteData.note,
                noteData.time,
                noteData.isDeleted,
                noteData.isPinned
            )
        )
        emit(Unit)
    }.flowOn(Dispatchers.IO)

}