package com.venkatesh.featuredashboard.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.venkatesh.featuredashboard.Resource
import com.venkatesh.featuredashboard.models.Album
import com.venkatesh.featuredashboard.remote.DashboardApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class PhotosViewModel @Inject constructor(dashboardApi: DashboardApi) : ViewModel() {

    private val TAG = "PhotosViewModel"
    private val dashboardApi: DashboardApi = dashboardApi
    private lateinit var photos: MediatorLiveData<Resource<List<Album>>>

    fun observePhotos(): LiveData<Resource<List<Album>>> {
        if (photos == null) {
            photos = MediatorLiveData()
            photos.value = Resource.loading(null as List<Album>?)

            val source: LiveData<Resource<List<Album>>> =
                LiveDataReactiveStreams.fromPublisher(
                    dashboardApi.getPhotos()
                        .onErrorReturn(
                            (Function<Throwable?, List<Album>> { t ->
                                Log.e(TAG, "apply :", t)
                                val album = Album()
                                album.id = "-1"
                                val photosList: ArrayList<Album> = ArrayList()
                                photosList.add(album)
                                photosList
                            })
                        )
                        .map(object :
                            Function<List<Album>, Resource<List<Album>>> {
                            @Throws(Exception::class)
                            override fun apply(photos: List<Album>): Resource<List<Album>> {
                                if (photos.isNotEmpty()) {
                                    if (photos[0].id === "-1") {
                                        return Resource.error("Something went wrong", null)
                                    }
                                }
                                return Resource.success(photos)
                            }
                        })
                        .subscribeOn(Schedulers.io())
                )

            photos.addSource(
                source
            ) { listResource ->
                photos.value = listResource
                photos.removeSource(source)
            }
        }
        return photos
    }

}