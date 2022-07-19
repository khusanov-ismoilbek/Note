package uz.gita.noteappgita.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.noteappgita.data.model.CheckData
import uz.gita.noteappgita.domain.usecase.EditCheckScreenUseCase
import uz.gita.noteappgita.presentation.viewmodel.EditCheckScreenViewModel
import javax.inject.Inject

@HiltViewModel
class EditCheckScreenViewModelImpl @Inject constructor(private val editCheckScreenUseCase: EditCheckScreenUseCase) :
    ViewModel(), EditCheckScreenViewModel {
    override val onClickBackLiveData = MutableLiveData<Unit>()

    override fun onClickBack() {
        onClickBackLiveData.value = Unit
    }

    override fun onClickSaveButton(data: CheckData) {
        editCheckScreenUseCase.updateCheckData(data).onEach {

        }.launchIn(viewModelScope)
    }

    override fun onClickDelete(data: CheckData) {
        editCheckScreenUseCase.deleteCheckData(data).onEach {

        }.launchIn(viewModelScope)
    }

}