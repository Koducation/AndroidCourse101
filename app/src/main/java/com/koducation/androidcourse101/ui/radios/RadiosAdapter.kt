package com.koducation.androidcourse101.ui.radios

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koducation.androidcourse101.data.remote.model.Radio
import com.koducation.androidcourse101.databinding.ItemRadioBinding
import javax.inject.Inject

class RadiosAdapter @Inject constructor(): RecyclerView.Adapter<RadiosAdapter.RadioItemViewHolder>() {

    private val radiosList = arrayListOf<Radio>()

    var radioItemClicked: ((Radio) -> Unit)? = null

    fun setRadioList(radiosList: List<Radio>) {
        this.radiosList.clear()
        this.radiosList.addAll(radiosList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = radiosList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioItemViewHolder =
        RadioItemViewHolder.create(parent, radioItemClicked)

    override fun onBindViewHolder(holder: RadioItemViewHolder, position: Int) =
        holder.bind(radiosList[position])

    class RadioItemViewHolder(
        private val binding: ItemRadioBinding,
        private val radioItemClicked: ((Radio) -> Unit)?
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                radioItemClicked?.invoke(binding.viewState?.radio!!)
            }
        }

        fun bind(radioItem: Radio) {
            binding.viewState = RadiosItemViewState(radioItem)
            binding.executePendingBindings()
        }

        companion object {

            fun create(
                parent: ViewGroup,
                radioItemClicked: ((Radio) -> Unit)?
            ): RadioItemViewHolder {
                val binding = ItemRadioBinding.inflate(LayoutInflater.from(parent.context))
                return RadioItemViewHolder(binding, radioItemClicked)
            }
        }

    }
}