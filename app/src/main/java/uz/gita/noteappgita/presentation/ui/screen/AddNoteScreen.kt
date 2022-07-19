package uz.gita.noteappgita.presentation.ui.screen

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.wordpress.aztec.Aztec
import org.wordpress.aztec.ITextFormat
import org.wordpress.aztec.toolbar.IAztecToolbarClickListener
import uz.gita.noteAppGita.R
import uz.gita.noteAppGita.databinding.ScreenAddNoteBinding
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.presentation.viewmodel.NoteScreenViewModel
import uz.gita.noteappgita.presentation.viewmodel.impl.NoteScreenViewModelImpl
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class AddNoteScreen : Fragment(R.layout.screen_add_note) {
    private val binding by viewBinding(ScreenAddNoteBinding::bind)
    private val viewModel: NoteScreenViewModel by viewModels<NoteScreenViewModelImpl>()

    @RequiresApi(Build.VERSION_CODES.O)
    private val current = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ofPattern("yyy-MM-dd")

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatted = current.format(formatter)

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.backLiveData.observe(viewLifecycleOwner, backObserver)

        val listener = object : IAztecToolbarClickListener {
            override fun onToolbarCollapseButtonClicked() {}
            override fun onToolbarExpandButtonClicked() {}
            override fun onToolbarFormatButtonClicked(
                format: ITextFormat,
                isKeyboardShortcut: Boolean
            ) {
            }

            override fun onToolbarHeadingButtonClicked() {}
            override fun onToolbarHtmlButtonClicked() {}
            override fun onToolbarListButtonClicked() {}
            override fun onToolbarMediaButtonClicked(): Boolean = false
        }
        Aztec.with(binding.editor, binding.tools, listener)

        binding.editor.setTextColor(Color.BLACK)

        binding.saveButton.setOnClickListener {
            viewModel.onClickSaveButton(
                NoteData(
                    0,
                    binding.titleText.text.toString(),
                    binding.editor.toFormattedHtml(),
                    formatted,
                    0,
                    0
                )
            )
            findNavController().popBackStack()
        }
        binding.backButton.setOnClickListener {
            viewModel.onClickBack()
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val backObserver = Observer<Unit> {
        viewModel.onClickSaveButton(
            NoteData(
                0,
                binding.titleText.text.toString(),
                binding.editor.toFormattedHtml(),
                formatted,
                0,
                0
            )
        )
        findNavController().popBackStack()
    }
}