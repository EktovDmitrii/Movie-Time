package com.example.dreamcinema.presentation.detailFragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dreamcinema.R
import com.example.dreamcinema.databinding.RecommendationCardBinding
import com.example.dreamcinema.domain.MovieInfo

class MovieRecommendationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: RecommendationCardBinding = RecommendationCardBinding.bind(itemView)

    fun bind(movieInfo: MovieInfo) {
        with(movieInfo) {
            binding.tvMovieName.text = title
            binding.tvRecomMovieRate.text = voteAverage.toString()
            if (posterPath != null) {
                Glide.with(itemView).load(BASE_URL + posterPath)
                    .into(binding.ivRecomMovieImage)
            } else {
                Glide.with(itemView).load(R.drawable.ic_baseline_image_not_supported_24)
                    .into(binding.ivRecomMovieImage)
            }
        }
    }

    companion object {
        private const val BASE_URL = "https://image.tmdb.org/t/p/original/"
    }
}