package uz.gita.note.presentation.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.note.data.model.CheckData

interface CheckScreenViewModel {
    val onclickBackLiveData: LiveData<Unit>

    fun onClickBack()
    fun onClickSave(data: CheckData)
}