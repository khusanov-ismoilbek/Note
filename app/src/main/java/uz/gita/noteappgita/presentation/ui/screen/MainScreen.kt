package uz.gita.noteappgita.presentation.ui.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppGita.R
import uz.gita.noteAppGita.databinding.ScreenMainBinding
import uz.gita.noteappgita.BuildConfig
import uz.gita.noteappgita.presentation.ui.adapter.PagerAdapter
import uz.gita.noteappgita.presentation.ui.dialog.AboutDialog
import uz.gita.noteappgita.presentation.viewmodel.MainViewModel
import uz.gita.noteappgita.presentation.viewmodel.impl.MainViewModelImpl

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private lateinit var adapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openNoteScreenLiveData.observe(this@MainScreen, openNoteScreenObserver)
        viewModel.openCheckScreenLiveData.observe(this@MainScreen, openCheckScreenObserver)
        viewModel.onClickRateLiveData.observe(this@MainScreen, onClickRateObserver)
        viewModel.onCLickAboutLiveData.observe(this@MainScreen, onCLickAboutObserver)
        viewModel.onCLickShareLiveData.observe(this@MainScreen, onClickShareObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = PagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager2.adapter = adapter

        viewModel.openPageLiveData.observe(viewLifecycleOwner, openPageObserver)
        viewModel.openDrawerLayoutLiveData.observe(viewLifecycleOwner, openDrawerLayoutObserver)
        viewModel.closeDrawerLayoutLiveData.observe(viewLifecycleOwner, closeDrawerLayoutObserver)

        binding.addButton.setOnClickListener {
            viewModel.openNextScreen()
        }
        viewModel.closeDrawerLayout()
        binding.burgerButton.setOnClickListener {
            viewModel.openDrawerLayout()
        }

        binding.navigationLayout.rate.setOnClickListener {
            viewModel.onClickRate()
        }

        binding.navigationLayout.about.setOnClickListener {
            viewModel.onClickAbout()
        }
        binding.navigationLayout.share.setOnClickListener {
            viewModel.onClickShare()
        }

        binding.viewPager2.isUserInputEnabled = false
        binding.bottomNavigationView.setOnItemReselectedListener { }
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottomNote -> {
                    viewModel.onClickBottomNav(0)
                    true
                }
                else -> {
                    viewModel.onClickBottomNav(1)
                    true
                }
            }
        }

    }

    private val openPageObserver = Observer<Int> {
        binding.viewPager2.currentItem = it
    }
    private val openCheckScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_mainScreen_to_addCheckScreen)
    }

    private val openNoteScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_mainScreen_to_addNoteScreen)
    }
    private val openDrawerLayoutObserver = Observer<Unit> {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }
    private val closeDrawerLayoutObserver = Observer<Unit> {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }
    private val onClickRateObserver = Observer<Unit> {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=${requireActivity().packageName}")
            )
        )
    }
    private val onClickShareObserver = Observer<Unit> {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        var body = "Notebook is a simple notes, easy and fast notepad to edit and manage notes\n\n"
        body += "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n"
        val subject = "Your subject"
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, body)
        startActivity(Intent.createChooser(intent, "share using"))
    }
    private val onCLickAboutObserver = Observer<Unit> {
        val dialog = AboutDialog()
        dialog.isCancelable = false

        dialog.setOnCLickGmailListener {
            val emailIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "khusanov.ismoilbek@gmail.com"))
            startActivity(emailIntent)
        }
        dialog.show(childFragmentManager, "dialog")
    }
}