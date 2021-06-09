package com.example.fetchexercise.hiringList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchexercise.databinding.ListItemHiringBinding
import com.example.fetchexercise.network.NetworkHiring

class HiringAdapter : androidx.recyclerview.widget.ListAdapter<NetworkHiring,
        HiringAdapter.ViewHolder>(NetworkHiringDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemHiringBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NetworkHiring) {
            binding.networkHiring = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemHiringBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minumum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class NetworkHiringDiffCallback : DiffUtil.ItemCallback<NetworkHiring>() {
    override fun areItemsTheSame(oldItem: NetworkHiring, newItem: NetworkHiring): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: NetworkHiring, newItem: NetworkHiring): Boolean {
        return oldItem == newItem
    }
}