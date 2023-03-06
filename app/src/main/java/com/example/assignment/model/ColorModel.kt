package com.example.assignment.model

import android.widget.ImageView

import androidx.databinding.BindingAdapter
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

data class ColorModel(

    @SerializedName("albumId") val albumId: Int = 0,

    @SerializedName("id") val id: Int = 0,

    @SerializedName("thumbnailUrl") val thumbnailUrl: String = "",

    @SerializedName("title") val title: String = "",

    @SerializedName("url") val url: String = ""

) : java.io.Serializable

// code for loading image here
@BindingAdapter("url")
fun loadImage(imageView: ImageView, imageURL: String) {
    Picasso.get().load(imageURL).placeholder(com.example.assignment.R.drawable.thumb).into(imageView)
}