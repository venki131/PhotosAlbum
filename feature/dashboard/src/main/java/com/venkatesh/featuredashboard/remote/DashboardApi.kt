package com.venkatesh.featuredashboard.remote

import com.venkatesh.featuredashboard.models.Album
import io.reactivex.Flowable
import retrofit2.http.GET

interface DashboardApi {

    @GET("v2/list")
    open fun getPhotos(): Flowable<List<Album>>
}