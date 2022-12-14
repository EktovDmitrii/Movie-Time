package main.pack.dreamcinema.presentation.favouriteFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import main.pack.dreamcinema.R
import main.pack.dreamcinema.domain.MovieDetailInfo
import main.pack.dreamcinema.presentation.CourseRvModel
import javax.inject.Inject

class FavouriteAdapter @Inject constructor(
    private val courseList: ArrayList<CourseRvModel>,
    private val context: Context?,
    val listener: OnMovieClickListener
) : ListAdapter<MovieDetailInfo, FavouriteViewHolder>(FavouriteMovieDiffCallBack) {

    var myData: List<MovieDetailInfo> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_favourite_info, parent, false)
        return FavouriteViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val movie = myData[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            listener.onMovieClick(movie)
        }
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    interface OnMovieClickListener {
        fun onMovieClick(movieDetailInfo: MovieDetailInfo)
    }
}
