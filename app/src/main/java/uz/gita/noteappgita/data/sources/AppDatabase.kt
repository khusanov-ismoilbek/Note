package uz.gita.noteappgita.data.sources

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.noteappgita.data.sources.dao.CheckDao
import uz.gita.noteappgita.data.sources.dao.NoteDao
import uz.gita.noteappgita.data.sources.entity.CheckEntity
import uz.gita.noteappgita.data.sources.entity.NoteEntity

@Database(entities = [NoteEntity::class, CheckEntity::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
    abstract fun getCheckDao(): CheckDao
}