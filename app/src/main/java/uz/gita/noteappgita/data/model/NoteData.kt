package uz.gita.noteappgita.data.model

import java.io.Serializable

data class NoteData(
    val id: Int,
    val title: String? = "",
    val note: String? = "",
    val time: String?,
    val isDeleted: Int,
    val isPinned: Int
): Serializable
