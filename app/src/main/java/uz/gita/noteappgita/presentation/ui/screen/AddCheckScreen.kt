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
import uz.gita.noteAppGita.databinding.ScreenAddCheckBinding
import uz.gita.noteappgita.data.model.CheckData
import uz.gita.noteappgita.presentation.viewmodel.CheckScreenViewModel
import uz.gita.noteappgita.presentation.viewmodel.impl.CheckScreenViewModelImpl
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class AddCheckScreen : Fragment(R.layout.screen_add_check) {
    private val binding by viewBinding(ScreenAddCheckBinding::bind)
    private val viewModel: CheckScreenViewModel by viewModels<CheckScreenViewModelImpl>()

    @RequiresApi(Build.VERSION_CODES.O)
    private val current = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ofPattern("yyy-MM-dd")

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatted = current.format(formatter)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.onclickBackLiveData.observe(viewLifecycleOwner, onClickBackObserver)

        binding.backButton.setOnClickListener {
            viewModel.onClickBack()
        }
        binding.saveButton.setOnClickListener {
            viewModel.onClickSave(
                CheckData(
                    0,
                    binding.addCheckText.text.toString(),
                    formatted,
                    0,
                    0,
                    0
                )
            )
            findNavController().popBackStack()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val onClickBackObserver = Observer<Unit> {
        viewModel.onClickSave(
            CheckData(
                0,
                binding.addCheckText.text.toString(),
                formatted,
                0,
                0,
                0
            )
        )
        findNavController().popBackStack()
    }
}