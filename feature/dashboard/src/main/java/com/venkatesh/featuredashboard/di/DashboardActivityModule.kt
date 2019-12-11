package com.venkatesh.featuredashboard.di

import com.venkatesh.featuredashboard.fragments.MyItemRecyclerViewAdapter
import com.venkatesh.featuredashboard.fragments.PhotosRecyclerAdapter
import com.venkatesh.featuredashboard.remote.DashboardApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DashboardActivityModule {
    @DashboardScope
    @Provides
    fun provideDashboardApi(retrofit: Retrofit): DashboardApi {
        return retrofit.create(DashboardApi::class.java)
    }

    @DashboardScope
    @Provides
    fun provideAdapter(): PhotosRecyclerAdapter? {
        return PhotosRecyclerAdapter()
    }
}