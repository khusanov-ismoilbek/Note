package uz.gita.note.domain.repository.impl

import uz.gita.note.data.sources.dao.CheckDao
import uz.gita.note.data.sources.dao.NoteDao
import uz.gita.note.data.sources.entity.CheckEntity
import uz.gita.note.data.sources.entity.NoteEntity
import uz.gita.note.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val databaseNote: NoteDao,
    private val databaseCheck: CheckDao
) : AppRepository {
    override suspend fun getAllNotes(): List<NoteEntity> {
        return databaseNote.getAllNotes()
    }

    override suspend fun insertNote(data: NoteEntity) {
        databaseNote.insertNote(data)
    }

    override suspend fun updateNote(data: NoteEntity) {
        databaseNote.updateNote(data)
    }

    override suspend fun deleteNote(data: NoteEntity) {
        databaseNote.deleteNote(data)
    }

    override suspend fun getAllCheck(): List<CheckEntity> {
        return databaseCheck.getAllCheckData()
    }

    override suspend fun insertCheck(data: CheckEntity) {
        databaseCheck.insertCheck(data)
    }

    override suspend fun updateCheck(data: CheckEntity) {
        databaseCheck.updateCheck(data)
    }

    override suspend fun deleteCheck(data: CheckEntity) {
        databaseCheck.deleteCheck(data)
    }

}