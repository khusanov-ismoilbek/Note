package uz.gita.note.data.sources

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.note.data.sources.dao.CheckDao
import uz.gita.note.data.sources.dao.NoteDao
import uz.gita.note.data.sources.entity.CheckEntity
import uz.gita.note.data.sources.entity.NoteEntity

@Database(entities = [NoteEntity::class, CheckEntity::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
    abstract fun getCheckDao(): CheckDao
}