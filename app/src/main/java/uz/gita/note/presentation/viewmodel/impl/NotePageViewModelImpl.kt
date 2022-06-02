package uz.gita.note.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.note.data.model.NoteData
import uz.gita.note.domain.usecase.NotePageUseCase
import uz.gita.note.presentation.viewmodel.NotePageViewModel
import javax.inject.Inject

@HiltViewModel
class NotePageViewModelImpl @Inject constructor(private val useCase: NotePageUseCase) : ViewModel(),
    NotePageViewModel {

    override val loadNoteData = MutableLiveData<List<NoteData>>()
    override val clickItemLiveNoteData = MutableLiveData<NoteData>()
    override val notEmptyLiveData = MutableLiveData<Unit>()
    override val emptyLiveData = MutableLiveData<Unit>()

    override fun load() {
        useCase.getAllNotes().onEach {
            loadNoteData.value = it
            if (it.isNotEmpty()){
                notEmptyLiveData.value = Unit
            }else{
                emptyLiveData.value = Unit
            }
        }.launchIn(viewModelScope)
    }

    override fun onClickItem(noteData: NoteData) {
        clickItemLiveNoteData.value = noteData
    }
}