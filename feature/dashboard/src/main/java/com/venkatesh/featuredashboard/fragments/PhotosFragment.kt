package com.venkatesh.featuredashboard.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.venkatesh.featuredashboard.R
import com.venkatesh.featuredashboard.Resource
import com.venkatesh.featuredashboard.fragments.dummy.DummyContent.DummyItem
import com.venkatesh.featuredashboard.models.Album
import com.venkatesh.featuredashboard.viewmodels.PhotosViewModel
import com.venkatesh.featuredashboard.viewmodels.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_item_list.*
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [PhotosFragment.OnListFragmentInteractionListener] interface.
 */
class PhotosFragment : Fragment() {

    private val TAG = "PhotosFragment"
    private var viewModel: PhotosViewModel? = null

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var adapter: PhotosRecyclerAdapter

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Set the adapter
        /*if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter =
                    MyItemRecyclerViewAdapter(
                        DummyContent.ITEMS,
                        listener
                    )
            }
        }*/
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, providerFactory).get(PhotosViewModel::class.java)

        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel?.observePhotos()?.removeObservers(viewLifecycleOwner)
        viewModel?.observePhotos()
            ?.observe(viewLifecycleOwner,
                Observer<Resource<List<Album>>?> { listResource ->
                    when (listResource?.status) {
                        Resource.Status.LOADING -> Log.d(
                            TAG,
                            "onChanged: onLoading..."
                        )
                        Resource.Status.SUCCESS -> {
                            Log.d(
                                TAG,
                                "onChanged: got posts..."
                            )
                            //adapter.setPhotos(listResource?.data)
                        }
                        Resource.Status.ERROR -> Log.d(
                            TAG,
                            "onChanged: on Error..." + listResource.message
                        )
                    }
                })
    }

    private fun initRecyclerView() {
        list.layoutManager = LinearLayoutManager(activity)
        list.adapter = adapter
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            PhotosFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
