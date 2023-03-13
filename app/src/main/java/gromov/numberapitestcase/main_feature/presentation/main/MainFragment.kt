package gromov.numberapitestcase.main_feature.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import gromov.numberapitestcase.R
import gromov.numberapitestcase.databinding.FragmentMainBinding
import gromov.numberapitestcase.main_feature.presentation.model.NumberFactView
import gromov.numbersapi.core.extension.collectLifecycleFlow
import gromov.numbersapi.numbers_feature.presentation.main.adapter.NumberListAdapter
import gromov.ramdomusertestcase.core.extension.autoCleaned

@AndroidEntryPoint
class MainFragment : Fragment(), NumberListAdapter.OnClickListener {


    private var binding : FragmentMainBinding by autoCleaned()
    private val viewModel by viewModels<MainViewModel>()
    private var adapter : NumberListAdapter by autoCleaned()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindAdapter()
        setClickListeners()
        observeViewModel()
    }

    private fun observeViewModel() {
        collectLifecycleFlow(viewModel.historyNumbers)  {
            adapter.submitList(it)
        }
        collectLifecycleFlow(viewModel.errorMessage) {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setClickListeners() {
        binding.getFactButton.setOnClickListener {
            val number = binding.numberEditText.text.toString()
            if (number.isEmpty()) {
                binding.numberEditText.error = "Enter number"
                return@setOnClickListener
            } else {
                binding.numberEditText.error = null
                viewModel.getNumber(binding.numberEditText.text.toString().toInt())
            }
        }
        binding.getRandomFactButton.setOnClickListener {
            viewModel.getRandomNumber()
        }
    }

    private fun bindAdapter() {
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        adapter = NumberListAdapter()
        binding.historyRecyclerView.adapter = adapter
        linearLayoutManager.isSmoothScrollbarEnabled = true
        binding.historyRecyclerView.layoutManager = linearLayoutManager
        adapter.onClickListener = this
    }

    override fun onClick(number: NumberFactView) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToDetailsFragment(
                number
            )
        )
    }
}