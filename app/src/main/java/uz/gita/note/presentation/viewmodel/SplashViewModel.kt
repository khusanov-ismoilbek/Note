package uz.gita.note.presentation.viewmodel

import androidx.lifecycle.LiveData

interface SplashViewModel {
    val openNextScreenLiveData: LiveData<Unit>
}