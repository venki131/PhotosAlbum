package com.venkatesh.photosalbum.di

import androidx.lifecycle.ViewModelProvider
import com.venkatesh.featuredashboard.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindsFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}