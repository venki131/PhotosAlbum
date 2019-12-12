package com.venkatesh.featuredashboard.di

import androidx.lifecycle.ViewModel
import com.venkatesh.featuredashboard.viewmodels.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DashboardViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    abstract fun bindAuthViewModel(photosViewModel: PhotosViewModel): ViewModel
}