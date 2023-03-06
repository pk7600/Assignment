package com.example.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.databinding.ItemMovieBinding
import com.example.assignment.model.ColorModel


class ColorAdapter : RecyclerView.Adapter<ColorAdapter.MyViewHolder>() {

    private val movieList: ArrayList<ColorModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding: ItemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_movie, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mMovie: ColorModel = movieList[position]
        holder.itemMovieBinding.image = mMovie
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setData(data: ArrayList<ColorModel>) {
        movieList.addAll(data)
        notifyDataSetChanged()
    }


    class MyViewHolder(@NonNull itemBinding: ItemMovieBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val itemMovieBinding: ItemMovieBinding
        init {
            itemMovieBinding = itemBinding
        }
    }


}