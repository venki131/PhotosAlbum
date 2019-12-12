package com.venkatesh.featuredashboard.di

import com.venkatesh.featuredashboard.fragments.FavouritesFragment
import com.venkatesh.featuredashboard.fragments.PhotosFragment
import com.venkatesh.featuredashboard.fragments.ShareFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributePhotosFragment(): PhotosFragment

    @ContributesAndroidInjector
    abstract fun contributeFavouritesFragment(): FavouritesFragment

    @ContributesAndroidInjector
    abstract fun contributeShareFragment(): ShareFragment
}
