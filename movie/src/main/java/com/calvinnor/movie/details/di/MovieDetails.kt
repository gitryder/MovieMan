package com.calvinnor.movie.details.di

import com.calvinnor.movie.details.domain.MovieDetailsC
import com.calvinnor.movie.details.domain.MovieDetailsRemote
import com.calvinnor.movie.details.domain.MovieDetailsRepo
import com.calvinnor.movie.details.viewmodel.MovieDetailsViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val movieDetailsModule = module {

    factory<MovieDetailsC.Remote> { MovieDetailsRemote(movieWebService = get()) }

    factory<MovieDetailsC.Repository> { MovieDetailsRepo(remote = get()) }

    viewModel { MovieDetailsViewModel(jobDispatcher = get(), movieRepo = get()) }

}