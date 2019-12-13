package com.venkatesh.photosalbum.di

import com.venkatesh.featuredashboard.DashboardActivity
import com.venkatesh.featuredashboard.di.DashboardActivityModule
import com.venkatesh.featuredashboard.di.DashboardScope
import com.venkatesh.featuredashboard.di.DashboardViewModelsModule
import com.venkatesh.featuredashboard.di.FragmentsBuilderModule
import com.venkatesh.photosalbum.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @DashboardScope
    @ContributesAndroidInjector(
        modules = [
            DashboardActivityModule::class,
            DashboardViewModelsModule::class,
            FragmentsBuilderModule::class
        ]
    )
    abstract fun provideDashboardActivity(): DashboardActivity?

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}