package uz.gita.note.data.sources.dao

import androidx.room.*
import uz.gita.note.data.sources.entity.NoteEntity

@Dao
interface NoteDao{

    @Insert()
    fun insertNote(data : NoteEntity)

    @Update
    fun updateNote(data: NoteEntity)

    @Delete
    fun deleteNote(data: NoteEntity)

    @Query("Select * From NoteEntity Where NoteEntity.isDeleted == 0")
    fun getAllNotes(): List<NoteEntity>

}