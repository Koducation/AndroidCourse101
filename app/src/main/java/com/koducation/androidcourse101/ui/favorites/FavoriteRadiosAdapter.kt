package com.koducation.androidcourse101.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.databinding.ItemFavoriteRadioBinding
import javax.inject.Inject

class FavoriteRadiosAdapter @Inject constructor():
    RecyclerView.Adapter<FavoriteRadiosAdapter.FavoriteRadioItemViewHolder>() {

    private val favoriteViewStateList = arrayListOf<FavoriteRadioItemViewState>()

    var onFavoriteClicked: ((FavoriteRadioItemViewState) -> Unit)? = null

    fun updateFavoriteList(favoriteViewStateList: List<FavoriteRadioItemViewState>) {
        this.favoriteViewStateList.clear()
        this.favoriteViewStateList.addAll(favoriteViewStateList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteRadioItemViewHolder =
        FavoriteRadioItemViewHolder.create(parent, onFavoriteClicked)

    override fun getItemCount(): Int = favoriteViewStateList.size

    override fun onBindViewHolder(holder: FavoriteRadioItemViewHolder, position: Int) =
        holder.bind(favoriteViewStateList[position])

    class FavoriteRadioItemViewHolder(
        private val binding: ItemFavoriteRadioBinding,
        private val onFavoriteClicked: ((FavoriteRadioItemViewState) -> Unit)?
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.imageViewFavoriteAction.setOnClickListener {
                onFavoriteClicked?.invoke(binding.viewState!!)
            }
        }

        fun bind(favoriteRadioItemViewState: FavoriteRadioItemViewState) {
            binding.viewState = favoriteRadioItemViewState
            binding.executePendingBindings()
        }

        companion object {

            fun create(
                parent: ViewGroup,
                onFavoriteClicked: ((FavoriteRadioItemViewState) -> Unit)?
            ): FavoriteRadioItemViewHolder {
                val binding: ItemFavoriteRadioBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_favorite_radio,
                    parent,
                    false
                )
                return FavoriteRadioItemViewHolder(binding, onFavoriteClicked)
            }
        }
    }
}