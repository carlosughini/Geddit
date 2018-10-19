package com.example.carlo.geddit.features

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carlo.geddit.R
import com.example.carlo.geddit.commons.RedditNewsItem
import com.example.carlo.geddit.commons.adapter.NewsAdapter
import com.example.carlo.geddit.commons.extensions.inflate
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment : Fragment() {

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
        news_list.setHasFixedSize(true)
        // Set the layout manager
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) { news.add(RedditNewsItem(
                "author$i",
                "Title $i",
                i, // number of comments
                1457207701L - i * 200, // time
                "http://lorempixel.com/200/200/technics/$i", // image url
                "url"
            ))
            }
            (news_list.adapter as NewsAdapter).addNews(news)
        }
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }

}
