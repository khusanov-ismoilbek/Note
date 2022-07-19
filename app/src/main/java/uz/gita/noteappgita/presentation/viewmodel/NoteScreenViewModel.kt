package uz.gita.noteappgita.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.noteappgita.data.model.NoteData

interface NoteScreenViewModel {
    val backLiveData: LiveData<Unit>

    fun onClickSaveButton(noteData: NoteData)
    fun onClickBack()

}