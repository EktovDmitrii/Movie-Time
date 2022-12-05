package com.example.dreamcinema.presentation.genreFragment

import androidx.recyclerview.widget.DiffUtil
import com.example.dreamcinema.domain.MovieInfo

object MovieByGenreDiffCallBack : DiffUtil.ItemCallback<MovieInfo>(){

    override fun areItemsTheSame(oldItem: MovieInfo, newItem: MovieInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieInfo, newItem: MovieInfo): Boolean {
        return oldItem == newItem
    }
}