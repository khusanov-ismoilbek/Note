package uz.gita.note.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.note.presentation.viewmodel.SplashViewModel

class SplashVIewModelImpl : SplashViewModel, ViewModel() {
    override val openNextScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(1500)
            openNextScreenLiveData.value = Unit
        }
    }
}