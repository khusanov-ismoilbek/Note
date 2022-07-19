package uz.gita.noteappgita.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.noteappgita.presentation.viewmodel.SplashViewModel

class SplashVIewModelImpl : SplashViewModel, ViewModel() {
    override val openNextScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(1500)
            openNextScreenLiveData.value = Unit
        }
    }
}