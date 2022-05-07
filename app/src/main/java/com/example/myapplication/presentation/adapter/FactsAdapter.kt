package com.example.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.presentation.adapter.FactsAdapter.FactViewHolder

class FactsAdapter : RecyclerView.Adapter<FactViewHolder>() {

    class FactViewHolder(view: View) : ViewHolder(view) {
        val factTextView: TextView = view.findViewById(R.id.fact_text)
    }

    private val factList = mutableListOf<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FactViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)

        return FactViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FactViewHolder,
        position: Int
    ) {
        holder.factTextView.text = factList[position]
    }

    override fun getItemCount(): Int = factList.size

    fun setFacts(facts: List<String>?) {
        facts?.let {
            factList.clear()
            factList.addAll(it)
            notifyDataSetChanged()
        }
    }
}