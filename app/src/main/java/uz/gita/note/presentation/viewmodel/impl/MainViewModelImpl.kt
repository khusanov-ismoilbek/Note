package uz.gita.note.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.note.presentation.viewmodel.MainViewModel

class MainViewModelImpl : MainViewModel,
    ViewModel() {

    override val openNoteScreenLiveData = MutableLiveData<Unit>()
    override val openCheckScreenLiveData = MutableLiveData<Unit>()
    override val openDrawerLayoutLiveData = MutableLiveData<Unit>()
    override val closeDrawerLayoutLiveData = MutableLiveData<Unit>()
    override val openPageLiveData = MutableLiveData<Int>()
    override val onClickRateLiveData = MutableLiveData<Unit>()
    override val onCLickAboutLiveData = MutableLiveData<Unit>()
    override val onCLickShareLiveData = MutableLiveData<Unit>()
    private var position = 0

    override fun openDrawerLayout() {
        openDrawerLayoutLiveData.value = Unit
    }

    override fun closeDrawerLayout() {
        closeDrawerLayoutLiveData.value = Unit
    }

    override fun onClickBottomNav(pos: Int) {
        if (pos == position) return
        openPageLiveData.value = pos
        position = pos
    }

    override fun openNextScreen() {
        if (position == 0) openNoteScreenLiveData.value = Unit
        else openCheckScreenLiveData.value = Unit
    }

    override fun onClickRate() {
        onClickRateLiveData.value = Unit
    }

    override fun onClickAbout() {
        onCLickAboutLiveData.value = Unit
    }

    override fun onClickShare() {
        onCLickShareLiveData.value = Unit
    }

}