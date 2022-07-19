package uz.gita.noteappgita.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.domain.usecase.NoteScreenUseCae
import uz.gita.noteappgita.presentation.viewmodel.NoteScreenViewModel
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModelImpl @Inject constructor(private val useCase: NoteScreenUseCae) :
    ViewModel(), NoteScreenViewModel {
    override val backLiveData = MutableLiveData<Unit>()

    override fun onClickSaveButton(noteData: NoteData) {
        useCase.insertNote(noteData).onEach {

        }.launchIn(viewModelScope)

    }

    override fun onClickBack() {
        backLiveData.value = Unit
    }


}