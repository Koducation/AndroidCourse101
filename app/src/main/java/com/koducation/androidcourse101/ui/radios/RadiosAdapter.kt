package com.koducation.androidcourse101.ui.radios

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koducation.androidcourse101.data.model.Radio
import com.koducation.androidcourse101.databinding.ItemRadioBinding
import com.squareup.picasso.Picasso

class RadiosAdapter : RecyclerView.Adapter<RadiosAdapter.RadioItemViewHolder>() {

    private val radiosList = arrayListOf<Radio>()

    fun setRadioList(radiosList: List<Radio>) {
        this.radiosList.clear()
        this.radiosList.addAll(radiosList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = radiosList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioItemViewHolder =
        RadioItemViewHolder.create(parent)

    override fun onBindViewHolder(holder: RadioItemViewHolder, position: Int) =
        holder.bind(radiosList[position])

    class RadioItemViewHolder(private val binding: ItemRadioBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(radioItem: Radio) {
            binding.viewState = RadiosItemViewState(radioItem)
            binding.executePendingBindings()
        }

        companion object {

            fun create(parent: ViewGroup): RadioItemViewHolder {
                val binding = ItemRadioBinding.inflate(LayoutInflater.from(parent.context))
                return RadioItemViewHolder(binding)
            }
        }

    }
}