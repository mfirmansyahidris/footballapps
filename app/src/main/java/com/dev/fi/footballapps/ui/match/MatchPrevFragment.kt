package com.dev.fi.footballapps.ui.match

import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.ui.match.MatchFragment.Companion.prevMatchCountingIdlingResource
import com.dev.fi.footballapps.utils.SpinnerListener1
import com.dev.fi.footballschedule2.base.BaseFragment
import com.dev.fi.footballschedule2.data.model.Event
import com.dev.fi.footballschedule2.rest.Repository
import com.dev.fi.footballschedule2.utils.invisible
import com.dev.fi.footballschedule2.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match_child.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class MatchPrevFragment : BaseFragment(), MatchV, SpinnerListener1 {
    private var items: MutableList<Event> = mutableListOf()
    private lateinit var presenter: MatchP
    override fun getLayoutResource(): Int = R.layout.fragment_match_child

    override fun mainCode() {
        MatchFragment.setSpinnerListener1(this)
        rv_match.id = R.id.rv_match_prev
        rv_match.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_match.layoutManager = LinearLayoutManager(activity)

        val request = Repository()
        val gson = Gson()
        presenter = MatchP(this, request, gson)
    }

    override fun onItemSelected(item: String) {
        presenter.getPrevMatch(item)
    }

    override fun onProcess() {
        prevMatchCountingIdlingResource.increment()
        rv_match.invisible()
        pb_process.visible()
    }

    override fun onDone() {
        prevMatchCountingIdlingResource.decrement()
        rv_match.visible()
        pb_process.invisible()
    }

    override fun showResult(data: List<Event>) {
        items.clear()
        items.addAll(data)
        rv_match.adapter = MatchAdapter(activity, items) {
            //TODO: match adapter listener
        }
    }

}