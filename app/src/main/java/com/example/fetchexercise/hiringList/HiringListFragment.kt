package com.example.fetchexercise.hiringList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fetchexercise.R
import com.example.fetchexercise.databinding.FragmentHiringListBinding


class HiringListFragment : Fragment() {

    private lateinit var viewModel: HiringListViewModel
    private lateinit var binding: FragmentHiringListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_hiring_list, container, false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HiringListViewModel::class.java)

        val adapter = HiringAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.hiring.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }
}