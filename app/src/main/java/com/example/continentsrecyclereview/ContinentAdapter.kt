package com.example.continentsrecyclereview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.continentsrecyclereview.databinding.ItemContinentBinding

class ContinentsAdapter(private val items: List<Continent>,
    private val onClick: OnClick) :
    RecyclerView.Adapter<ContinentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemContinentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClick.onClick(item)
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemContinentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Continent) {
            binding.ivContinent.load(item.image)
        }
    }
}