package uz.gita.noteappgita.data.sources.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class CheckEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val checkText: String?,
    val time: String?,
    val isDeleted: Int,
    val isPinned: Int,
    val state: Int
)