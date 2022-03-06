package com.asimodabas.art_book.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class ArtRecyclerAdapter @Inject constructor(
    val glide:RequestManager
) : RecyclerView.Adapter<ArtRecyclerAdapter.ArtViewHolder>(){

    class ArtViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {

    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}