package uz.gita.note.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.note.data.model.NoteData

interface NoteScreenViewModel {
    val backLiveData: LiveData<Unit>

    fun onClickSaveButton(noteData: NoteData)
    fun onClickBack()

}