package uz.gita.noteappgita.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.noteappgita.data.model.CheckData
import uz.gita.noteappgita.domain.usecase.CheckPageUseCase
import uz.gita.noteappgita.presentation.viewmodel.CheckPageViewModel
import javax.inject.Inject

@HiltViewModel
class CheckPageViewModelImpl @Inject constructor(private val checkPageUseCase: CheckPageUseCase) :
    ViewModel(), CheckPageViewModel {
    override val getAllCheckLiveData = MutableLiveData<List<CheckData>>()
    override val onClickItemLiveData = MutableLiveData<CheckData>()
    override val noDataLiveData = MutableLiveData<Unit>()
    override val haveDataLiveData = MutableLiveData<Unit>()

    override fun loadAllData() {
        checkPageUseCase.getAllCheck().onEach {
            getAllCheckLiveData.value = it
            if (it.isEmpty()) {
                noDataLiveData.value = Unit
            } else {
                haveDataLiveData.value = Unit
            }
        }.launchIn(viewModelScope)
    }

    override fun onClickItem(data: CheckData) {
        onClickItemLiveData.value = data
    }

    override fun onClickCheckBox(data: CheckData) {
        checkPageUseCase.updateCheckBoxData(data).onEach {

        }.launchIn(viewModelScope)
    }


}