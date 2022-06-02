import uz.gita.note.data.model.CheckData
import uz.gita.note.data.model.NoteData
import uz.gita.note.data.sources.entity.CheckEntity
import uz.gita.note.data.sources.entity.NoteEntity

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

fun CheckEntity.toCheckData(): CheckData{
    return CheckData(
        id,
        checkText,
        time,
        isDeleted,
        isPinned,
        state
    )
}