package com.koducation.androidcourse101.ui.util.binding

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun loadImage(imageView: ImageView, url: String?) {
    if (url.isNullOrEmpty()) {
        return
    }
    Picasso.get().load(url).into(imageView)
}

@BindingAdapter("tintImage")
fun tintImage(imageView: ImageView, color: Int) {
    ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
}

@BindingAdapter("vector")
fun loadVector(imageView: ImageView, drawable: Drawable?) {
    imageView.setImageDrawable(drawable)
}