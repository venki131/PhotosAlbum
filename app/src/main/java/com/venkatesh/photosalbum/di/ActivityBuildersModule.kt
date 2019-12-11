package com.venkatesh.photosalbum.di

import com.venkatesh.featuredashboard.DashboardActivity
import com.venkatesh.featuredashboard.di.DashboardActivityModule
import com.venkatesh.featuredashboard.di.DashboardScope
import com.venkatesh.featuredashboard.di.DashboardViewModelsModule
import com.venkatesh.featuredashboard.di.FragmentsBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuildersModule {

    @DashboardScope
    @ContributesAndroidInjector(
        modules = [
            DashboardActivityModule::class,
            DashboardViewModelsModule::class,
            FragmentsBuilderModule::class
        ]
    )
    fun provideDashboardActivity(): DashboardActivity
}