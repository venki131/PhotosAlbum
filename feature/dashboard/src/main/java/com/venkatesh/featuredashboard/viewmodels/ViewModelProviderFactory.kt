package com.venkatesh.featuredashboard.viewmodels

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProviderFactory @Inject constructor(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    private val TAG = "ViewModelProviderFactor"

    private var creators: Map<Class<out ViewModel>, Provider<ViewModel>> = creators

    /* @Inject
     fun ViewModelProviderFactory(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) {
         this.creators = creators
     }*/

    @NonNull
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel?>? = creators?.get(modelClass)
        if (creator == null) { // if viewmodel has not been created
            // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
            for ((key, value) in creators) { //if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        //if this is not one of the allowed keys, throw exception
        requireNotNull(creator) { "unknown model class : $modelClass" }

        //return the provider
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}