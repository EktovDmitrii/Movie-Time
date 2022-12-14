package main.pack.dreamcinema.di

import androidx.lifecycle.ViewModel
import main.pack.dreamcinema.presentation.detailFragment.MovieDetailViewModel
import main.pack.dreamcinema.presentation.favouriteFragment.FavouriteViewModel
import main.pack.dreamcinema.presentation.genreFragment.GenreViewModel
import main.pack.dreamcinema.presentation.homeFragment.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @ViewModelKey(HomeViewModel::class)
    @IntoMap
    fun bindViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @ViewModelKey(GenreViewModel::class)
    @IntoMap
    fun bindGenreViewModel(viewModel: GenreViewModel): ViewModel

    @Binds
    @ViewModelKey(FavouriteViewModel::class)
    @IntoMap
    fun bindFavouriteViewModel(viewModel: FavouriteViewModel): ViewModel

    @Binds
    @ViewModelKey(MovieDetailViewModel::class)
    @IntoMap
    fun bindDetailViewModel(viewModel: MovieDetailViewModel): ViewModel
}