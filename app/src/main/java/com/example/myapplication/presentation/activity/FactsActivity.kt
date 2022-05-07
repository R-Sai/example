package com.example.myapplication.presentation.activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityFactsBinding
import com.example.myapplication.presentation.adapter.FactsAdapter
import com.example.myapplication.presentation.viewmodel.FactsViewModel

class FactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFactsBinding

    private val viewModel by viewModels<FactsViewModel>()
    private val factsAdapter = FactsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        observeData()
        viewModel.fetchFacts()
    }

    private fun initViews() {
        binding.refreshFloatingButton.setOnClickListener {
            viewModel.fetchFacts()
        }

        binding.factsRecyclerView.adapter = factsAdapter
        binding.factsRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.factsRecyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayout.VERTICAL)
        )
    }

    private fun observeData() {
        viewModel.catFactList.observe(this) { facts ->
            factsAdapter.setFacts(facts)
        }
    }
}