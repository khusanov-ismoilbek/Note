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
import uz.gita.noteAppGita.databinding.ScreenEditNoteBinding
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.presentation.ui.dialog.DeleteNoteDialog
import uz.gita.noteappgita.presentation.viewmodel.EditNoteScreenViewModel
import uz.gita.noteappgita.presentation.viewmodel.impl.EditNoteScreenViewModelImpl
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class EditNoteScreen : Fragment(R.layout.screen_edit_note) {
    private val binding by viewBinding(ScreenEditNoteBinding::bind)
    private val viewModelNote: EditNoteScreenViewModel by viewModels<EditNoteScreenViewModelImpl>()
    private lateinit var noteData: NoteData

    @RequiresApi(Build.VERSION_CODES.O)
    private val current = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ofPattern("yyy-MM-dd")

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatted = current.format(formatter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            noteData = it.getSerializable("DATA") as NoteData
        }
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModelNote.backLiveData.observe(viewLifecycleOwner, backObserver)

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
        Aztec.with(
            binding.editor,
            binding.tools,
            listener
        )
        binding.editor.setTextColor(Color.BLACK)

        binding.titleText.setText(noteData.title)
        binding.editor.fromHtml(noteData.note.toString())
        binding.backButton.setOnClickListener {
            viewModelNote.onClickBack()
        }
        binding.saveButton.setOnClickListener {
            viewModelNote.onClickUpdateButton(
                NoteData(
                    noteData.id,
                    binding.titleText.text.toString(),
                    binding.editor.toFormattedHtml(),
                    formatted,
                    0,
                    0
                )
            )
            findNavController().popBackStack()
        }

        binding.deleteButton.setOnClickListener {
            val dialog = DeleteNoteDialog()
            dialog.setOnclickYesBtnListener {
                viewModelNote.onClickDeleteButton(noteData)
                viewModelNote.onClickBack()
            }
            dialog.isCancelable = false
            dialog.show(childFragmentManager, "delete")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val backObserver = Observer<Unit> {
        viewModelNote.onClickUpdateButton(
            NoteData(
                noteData.id,
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