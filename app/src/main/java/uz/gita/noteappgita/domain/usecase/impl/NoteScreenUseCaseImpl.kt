package uz.gita.noteappgita.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.data.sources.entity.NoteEntity
import uz.gita.noteappgita.domain.repository.AppRepository
import uz.gita.noteappgita.domain.usecase.NoteScreenUseCae
import javax.inject.Inject

class NoteScreenUseCaseImpl @Inject constructor(private val appRepository: AppRepository) :
    NoteScreenUseCae {

    //    override fun insertNote(data: NoteData) {
//        noteScreenRepository.insertNote(
//            NoteEntity(
//                0,
//                data.title,
//                data.note,
//                data.time,
//                data.isDeleted,
//                data.isPinned
//            )
//        )
//    }
//
//    override fun updateNote(data: NoteData) {
//        noteScreenRepository.updateNote(
//            NoteEntity(
//                data.id,
//                data.title,
//                data.note,
//                data.time,
//                data.isDeleted,
//                data.isPinned
//            )
//        )
//    }
//
//    override fun deleteNote(data: NoteData) {
//        noteScreenRepository.deleteNote(
//            NoteEntity(
//                data.id,
//                data.title,
//                data.note,
//                data.time,
//                data.isDeleted,
//                data.isPinned
//            )
//        )
//    }
    override fun insertNote(noteData: NoteData): Flow<Unit> = flow {
        appRepository.insertNote(
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