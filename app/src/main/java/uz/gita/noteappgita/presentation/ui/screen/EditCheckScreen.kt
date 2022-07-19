package uz.gita.noteappgita.presentation.ui.screen

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
import uz.gita.noteAppGita.R
import uz.gita.noteAppGita.databinding.ScreenEditCheckBinding
import uz.gita.noteappgita.data.model.CheckData
import uz.gita.noteappgita.presentation.ui.dialog.DeleteNoteDialog
import uz.gita.noteappgita.presentation.viewmodel.EditCheckScreenViewModel
import uz.gita.noteappgita.presentation.viewmodel.impl.EditCheckScreenViewModelImpl
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class EditCheckScreen : Fragment(R.layout.screen_edit_check) {
    private val binding by viewBinding(ScreenEditCheckBinding::bind)
    private val viewModel: EditCheckScreenViewModel by viewModels<EditCheckScreenViewModelImpl>()
    private lateinit var checkData: CheckData

    @RequiresApi(Build.VERSION_CODES.O)
    private val current = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ofPattern("yyy-MM-dd")

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatted = current.format(formatter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            checkData = it.getSerializable("CHECK") as CheckData
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.addCheckText.setText(checkData.checkText)

        binding.backButton.setOnClickListener {
            viewModel.onClickBack()
        }

        binding.saveButton.setOnClickListener {
            viewModel.onClickSaveButton(
                CheckData(
                    checkData.id,
                    binding.addCheckText.text.toString(),
                    formatted,
                    0,
                    0,
                    checkData.state
                )
            )
            findNavController().popBackStack()
        }
        binding.deleteButton.setOnClickListener {
            val dialog = DeleteNoteDialog()
            dialog.setOnclickYesBtnListener {
                viewModel.onClickDelete(checkData)
                viewModel.onClickBack()
            }
            dialog.isCancelable = false
            dialog.show(childFragmentManager, "deleteCHECK")
        }
        viewModel.onClickBackLiveData.observe(viewLifecycleOwner, onClickBackObserver)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val onClickBackObserver = Observer<Unit> {
        viewModel.onClickSaveButton(
            CheckData(
                checkData.id,
                binding.addCheckText.text.toString(),
                formatted,
                0,
                0,
                checkData.state
            )
        )
        findNavController().popBackStack()
    }
}