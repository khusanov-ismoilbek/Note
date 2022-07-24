package uz.gita.noteappgita.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.domain.repository.AppRepository
import uz.gita.noteappgita.domain.usecase.NotePageUseCase
import uz.gita.noteappgita.utils.toNoteData
import javax.inject.Inject

class NotePageUseCaseImpl @Inject constructor(private val appRepository: AppRepository) :
    NotePageUseCase {
    override fun getAllNotes(): Flow<List<NoteData>> = flow {
        val list = appRepository.getAllNotes().map {
            it.toNoteData()
        }
        emit(list)
    }.flowOn(Dispatchers.IO)
}