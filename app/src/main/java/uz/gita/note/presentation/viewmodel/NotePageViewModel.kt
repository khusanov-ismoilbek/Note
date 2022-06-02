package uz.gita.note.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.note.data.model.NoteData

interface NotePageViewModel {
    val loadNoteData: LiveData<List<NoteData>>
    val clickItemLiveNoteData: LiveData<NoteData>
    val notEmptyLiveData: LiveData<Unit>
    val emptyLiveData: LiveData<Unit>

    fun load()
    fun onClickItem(noteData: NoteData)
}