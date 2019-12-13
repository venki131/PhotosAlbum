package com.venkatesh.featuredashboard.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.venkatesh.featuredashboard.R
import com.venkatesh.featuredashboard.models.Album
import kotlinx.android.synthetic.main.fragment_item.view.*
import java.util.*
import javax.inject.Inject

class PhotosRecyclerAdapter @Inject constructor(requestManager: RequestManager) : RecyclerView.Adapter<PhotosRecyclerAdapter.ViewHolder>() {

    private var photos: List<Album>? = ArrayList()
    private var requestManager: RequestManager = requestManager
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        requestManager.load(photos?.get(position)?.download_url).into(holder.mImageView)
    }

    override fun getItemCount(): Int {
        return photos!!.size
    }


    fun setPhotos(photos: List<Album>?) {
        this.photos = photos
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        val mImageView: ImageView = mView.image

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }

}