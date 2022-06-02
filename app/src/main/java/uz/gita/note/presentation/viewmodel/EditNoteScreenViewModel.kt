package uz.gita.note.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.note.data.model.NoteData

interface EditNoteScreenViewModel {

    val backLiveData: LiveData<Unit>

    fun onClickUpdateButton(noteData: NoteData)
    fun onClickDeleteButton(noteData: NoteData)
    fun onClickBack()
}