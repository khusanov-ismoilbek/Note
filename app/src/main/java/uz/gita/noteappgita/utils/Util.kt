package uz.gita.noteappgita.utils

import uz.gita.noteappgita.data.model.CheckData
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.data.sources.entity.CheckEntity
import uz.gita.noteappgita.data.sources.entity.NoteEntity

fun NoteEntity.toNoteData(): NoteData {
    return NoteData(
        id,
        title,
        note,
        time,
        isDeleted,
        isPinned
    )
}

fun CheckEntity.toCheckData(): CheckData {
    return CheckData(
        id,
        checkText,
        time,
        isDeleted,
        isPinned,
        state
    )
}