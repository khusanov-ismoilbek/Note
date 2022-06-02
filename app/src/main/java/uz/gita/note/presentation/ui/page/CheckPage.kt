package uz.gita.note.presentation.ui.page

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.note.R
import uz.gita.note.data.model.CheckData
import uz.gita.note.databinding.PageCheckBinding
import uz.gita.note.presentation.ui.adapter.CheckPageAdapter
import uz.gita.note.presentation.viewmodel.CheckPageViewModel
import uz.gita.note.presentation.viewmodel.impl.CheckPageViewModelImpl

@AndroidEntryPoint
class CheckPage : Fragment(R.layout.page_check) {
    private val binding by viewBinding(PageCheckBinding::bind)
    private val viewModel: CheckPageViewModel by viewModels<CheckPageViewModelImpl>()
    private val adapter = CheckPageAdapter()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAllCheckLiveData.observe(viewLifecycleOwner, getAllCheckObserver)
        viewModel.onClickItemLiveData.observe(this@CheckPage, onClickItemObserver)
        viewModel.noDataLiveData.observe(viewLifecycleOwner, noDataObserver)
        viewModel.haveDataLiveData.observe(viewLifecycleOwner, haveDataObserver)

        adapter.setOnClickItemListener {
            viewModel.onClickItem(it)
        }
        adapter.setOnClickCheckBoxListener {
            Log.d("RRR", it.toString())
            viewModel.onClickCheckBox(it)
            adapter.notifyDataSetChanged()
            viewModel.loadAllData()
        }
        viewModel.loadAllData()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private val getAllCheckObserver = Observer<List<CheckData>> {
        adapter.submitList(it)
    }
    private val onClickItemObserver = Observer<CheckData> {
        val bundle = Bundle()
        bundle.putSerializable("CHECK", it)
        findNavController().navigate(R.id.action_mainScreen_to_editCheckScreen, bundle)
    }
    private val noDataObserver = Observer<Unit> {
        binding.emptyPlace.visibility = View.VISIBLE
        binding.textEmpty.visibility = View.VISIBLE
    }
    private val haveDataObserver = Observer<Unit> {
        binding.emptyPlace.visibility = View.GONE
        binding.textEmpty.visibility = View.GONE

    }
}