package org.sopt.androidseminar

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("uploadImage")
fun uploadImage(view: ImageView, resource:Int){
    Glide.with(view.context)
        .load(resource)
        .into(view)
}