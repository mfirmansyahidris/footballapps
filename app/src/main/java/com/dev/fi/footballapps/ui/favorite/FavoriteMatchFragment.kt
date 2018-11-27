package com.dev.fi.footballapps.ui.favorite

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballapps.ui.match.MatchAdapter
import com.dev.fi.footballapps.utils.dbObject.DataEvent
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import kotlinx.android.synthetic.main.fragment_favorite_match.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class FavoriteMatchFragment: BaseFragment(){
    private var items: List<Event> = mutableListOf()
    override fun getLayoutResource(): Int = R.layout.fragment_favorite_match

    override fun mainCode() {
        rv_match.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_match.layoutManager = LinearLayoutManager(activity)

        initData()
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    private fun initData() {
        items = emptyList()
        items = DataEvent.getDatas(activity)
        if(items.isEmpty()){
            tv_msgFavorite.visible()
            rv_match.invisible()
        }else{
            tv_msgFavorite.invisible()
            rv_match.visible()
            rv_match.adapter = MatchAdapter(activity, items) {
                val intent = Intent(activity, DetailMatchActivity::class.java)
                intent.putExtra("event", it)
                startActivity(intent)
            }
        }
    }
}