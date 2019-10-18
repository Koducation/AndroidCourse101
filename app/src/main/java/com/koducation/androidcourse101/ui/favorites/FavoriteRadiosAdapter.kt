package com.koducation.androidcourse101.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.databinding.ItemFavoriteRadioBinding

class FavoriteRadiosAdapter :
    RecyclerView.Adapter<FavoriteRadiosAdapter.FavoriteRadioItemViewHolder>() {

    private val favoriteViewStateList = arrayListOf<FavoriteRadioItemViewState>()

    fun updateFavoriteList(favoriteViewStateList: List<FavoriteRadioItemViewState>) {
        this.favoriteViewStateList.clear()
        this.favoriteViewStateList.addAll(favoriteViewStateList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteRadioItemViewHolder =
        FavoriteRadioItemViewHolder.create(parent)

    override fun getItemCount(): Int = favoriteViewStateList.size

    override fun onBindViewHolder(holder: FavoriteRadioItemViewHolder, position: Int) =
        holder.bind(favoriteViewStateList[position])

    class FavoriteRadioItemViewHolder(private val binding: ItemFavoriteRadioBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favoriteRadioItemViewState: FavoriteRadioItemViewState) {
            binding.viewState = favoriteRadioItemViewState
            binding.executePendingBindings()
        }

        companion object {

            fun create(parent: ViewGroup): FavoriteRadioItemViewHolder {
                val binding: ItemFavoriteRadioBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_favorite_radio,
                    parent,
                    false
                )
                return FavoriteRadioItemViewHolder(binding)
            }
        }
    }
}