package uz.gita.noteappgita.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.noteappgita.data.model.CheckData

interface CheckScreenViewModel {
    val onclickBackLiveData: LiveData<Unit>

    fun onClickBack()
    fun onClickSave(data: CheckData)
}