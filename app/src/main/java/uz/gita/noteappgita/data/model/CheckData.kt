package uz.gita.noteappgita.data.model

import java.io.Serializable

data class CheckData(
    val id: Int,
    val checkText: String? = "",
    val time: String?,
    val isDeleted: Int,
    val isPinned: Int,
    val state: Int
) : Serializable
