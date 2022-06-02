package uz.gita.note.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.note.data.model.CheckData
import uz.gita.note.domain.usecase.CheckScreenUseCase
import uz.gita.note.presentation.viewmodel.CheckScreenViewModel
import javax.inject.Inject

@HiltViewModel
class CheckScreenViewModelImpl @Inject constructor(private val checkScreenUseCase: CheckScreenUseCase) :
    ViewModel(), CheckScreenViewModel {
    override val onclickBackLiveData = MutableLiveData<Unit>()

    override fun onClickBack() {
        onclickBackLiveData.value = Unit
    }

    override fun onClickSave(data: CheckData) {
        checkScreenUseCase.insertCheckData(data).onEach {

        }.launchIn(viewModelScope)
    }

}