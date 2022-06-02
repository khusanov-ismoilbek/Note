package uz.gita.note.data.sources.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val note: String?,
    val time: String?,
    val isDeleted: Int,
    val isPinned: Int
)