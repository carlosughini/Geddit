package com.example.carlo.geddit.features

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carlo.geddit.R
import com.example.carlo.geddit.inflate

class NewsFragment : Fragment() {

    /**
     * Lazy will initialize newsList with the value that we put in the code block.
     * With this, we avoid initializing our newsList as a nullable object.
     */
    private val newsList: RecyclerView by lazy {
        newsList // This will work as the return type
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflates fragment view
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /**
         * Improve performance of the recycler view by not requesting a new layout when
         * whenever items are inserted, moved or removed the size.
         */
        newsList.setHasFixedSize(true)
        // Set the layout manager
        newsList.layoutManager = LinearLayoutManager(context)
    }
}
