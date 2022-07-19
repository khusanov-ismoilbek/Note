package uz.gita.noteappgita.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.noteappgita.presentation.ui.page.CheckPage
import uz.gita.noteappgita.presentation.ui.page.NotePage

class PagerAdapter(fr: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fr, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NotePage()
            else -> CheckPage()
        }
    }
}