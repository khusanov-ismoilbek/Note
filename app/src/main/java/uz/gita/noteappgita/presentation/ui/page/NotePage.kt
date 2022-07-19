package uz.gita.noteappgita.presentation.ui.page

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.noteAppGita.R
import uz.gita.noteAppGita.databinding.PageNoteBinding
import uz.gita.noteappgita.data.model.NoteData
import uz.gita.noteappgita.presentation.ui.adapter.NotePageAdapter
import uz.gita.noteappgita.presentation.viewmodel.NotePageViewModel
import uz.gita.noteappgita.presentation.viewmodel.impl.NotePageViewModelImpl

@AndroidEntryPoint
class NotePage : Fragment(R.layout.page_note) {
    private val binding by viewBinding(PageNoteBinding::bind)
    private val viewModel: NotePageViewModel by viewModels<NotePageViewModelImpl>()
    private val adapter = NotePageAdapter()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadNoteData.observe(viewLifecycleOwner, loadDataObserver)
        viewModel.clickItemLiveNoteData.observe(this@NotePage, clickItemObserver)
        viewModel.notEmptyLiveData.observe(viewLifecycleOwner, notEmptyObserver)
        viewModel.emptyLiveData.observe(viewLifecycleOwner, emptyObserver)

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 2)

        adapter.setClickItemListener {
            viewModel.onClickItem(it)
        }

        viewModel.load()
    }

    private val loadDataObserver = Observer<List<NoteData>> {
        adapter.submitList(it.reversed())
    }

    private val clickItemObserver = Observer<NoteData> {
        val bundle = Bundle()
        bundle.putSerializable("DATA", it)
        findNavController().navigate(R.id.action_mainScreen_to_editNoteScreen, bundle)
    }
    private val notEmptyObserver = Observer<Unit> {
        binding.emptyPlace.visibility = View.GONE
        binding.textEmpty.visibility = View.GONE
    }
    private val emptyObserver = Observer<Unit> {
        binding.emptyPlace.visibility = View.VISIBLE
        binding.textEmpty.visibility = View.VISIBLE
    }
}