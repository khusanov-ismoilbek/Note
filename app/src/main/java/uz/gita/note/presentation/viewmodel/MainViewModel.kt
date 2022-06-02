package uz.gita.note.presentation.viewmodel

import androidx.lifecycle.LiveData

interface MainViewModel {
    val openDrawerLayoutLiveData: LiveData<Unit>
    val closeDrawerLayoutLiveData: LiveData<Unit>
    val openPageLiveData: LiveData<Int>
    val openNoteScreenLiveData: LiveData<Unit>
    val openCheckScreenLiveData: LiveData<Unit>
    val onClickRateLiveData: LiveData<Unit>
    val onCLickAboutLiveData: LiveData<Unit>
    val onCLickShareLiveData: LiveData<Unit>



    fun openDrawerLayout()
    fun closeDrawerLayout()
    fun onClickBottomNav(pos: Int)
    fun openNextScreen()
    fun onClickRate()
    fun onClickAbout()
    fun onClickShare()

}