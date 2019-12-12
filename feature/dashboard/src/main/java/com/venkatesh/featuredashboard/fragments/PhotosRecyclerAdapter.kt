package com.venkatesh.featuredashboard.fragments

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.venkatesh.featuredashboard.models.Album
import java.util.*

class PhotosRecyclerAdapter() : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private var photos: List<Album>? = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyItemRecyclerViewAdapter.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyItemRecyclerViewAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun setPhotos(photos: List<Album>?) {
        this.photos = photos
        notifyDataSetChanged()
    }
}