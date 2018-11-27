package com.dev.fi.footballapps.ui.match

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.ui.match.MatchFragment.Companion.nextMatchCountingIdlingResource
import com.dev.fi.footballapps.utils.SpinnerListener2
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match_child.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class MatchNextFragment : BaseFragment(), MatchV, SpinnerListener2 {
    private var isActive = true
    private var items: MutableList<Event> = mutableListOf()
    private lateinit var presenter: MatchP
    override fun getLayoutResource(): Int = R.layout.fragment_match_child

    override fun mainCode() {
        MatchFragment.setSpinnerListener2(this)
        rv_match.id = R.id.rv_match_next
        rv_match.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_match.layoutManager = LinearLayoutManager(activity)

        val request = Repository()
        val gson = Gson()
        presenter = MatchP(this, request, gson)
    }

    override fun onItemSelected(item: String) {
        presenter.getNextMatchList(item)
    }

    override fun onProcess() {
        nextMatchCountingIdlingResource.increment()
        if(isActive){
            rv_match.invisible()
            pb_process.visible()
        }
    }

    override fun onDone() {
        nextMatchCountingIdlingResource.decrement()
        if(isActive){
            rv_match.visible()
            pb_process.invisible()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isActive = false
    }

    override fun showResult(data: List<Event>) {
        items.clear()
        items.addAll(data)
        if(isActive){
            rv_match.adapter = MatchAdapter(activity, items) {
                val intent = Intent(activity, DetailMatchActivity::class.java)
                intent.putExtra("event", it)
                startActivity(intent)
            }
        }
    }

}
