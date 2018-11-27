package com.dev.fi.footballapps.ui.search

import android.annotation.SuppressLint
import android.content.Intent
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.espresso.idling.CountingIdlingResource
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseActivity
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.data.Team
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballapps.ui.match.MatchAdapter
import com.dev.fi.footballapps.ui.teams.TeamsAdapter
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_search.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class SearchActivity : BaseActivity(), SearchV {
    private lateinit var presenter: SearchP
    private lateinit var searchType: String
    override fun getLayoutResource(): Int = R.layout.activity_search

    override fun getToolbarResource(): Int = R.id.main_toolbar

    override fun getToolbarTitle(): String = ""

    @SuppressLint("RestrictedApi")
    override fun mainCode() {
        rv_searchResult.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_searchResult.layoutManager = LinearLayoutManager(this)

        val request = Repository()
        val gson = Gson()
        presenter = SearchP(this, request, gson)

        searchType = intent.getStringExtra("request")

        sv_match.onActionViewExpanded()
        sv_match.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.length!! > 2) {
                    if(searchType == "match"){
                        presenter.getSearchMatch(newText)
                    }else if(searchType == "teams"){
                        presenter.getSearchTeam(newText)
                    }
                }
                return true
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_search_action, menu)
        return true
    }


    override fun onProcess() {
        searchCountingIdlingResource.increment()
        pb_process.visible()
        rv_searchResult.invisible()
        tv_listMessage.invisible()
    }

    override fun onDone() {
        searchCountingIdlingResource.decrement()
        pb_process.invisible()
        rv_searchResult.visible()
        tv_listMessage.invisible()
    }

    override fun onEmpyResult() {
        tv_listMessage.text = getString(R.string.msg_emptyResult)
        tv_listMessage.visible()
        pb_process.invisible()
        rv_searchResult.invisible()
    }

    override fun showResult(data: List<Any>) {
        if(searchType == "match"){
            loadMatch(data as List<Event>)
        }else if (searchType == "teams"){
            loadTeam(data as List<Team>)
        }
    }

    private fun loadMatch(data: List<Event>){
        val items: MutableList<Event> = mutableListOf()
        items.clear()
        items.addAll(data)
        rv_searchResult.adapter = MatchAdapter(this, items) {
            val intent = Intent(this, DetailMatchActivity::class.java)
            intent.putExtra("event", it)
            startActivity(intent)
        }
    }

    private fun loadTeam(data: List<Team>){
        val items: MutableList<Team> = mutableListOf()
        items.clear()
        items.addAll(data)
        rv_searchResult.adapter = TeamsAdapter(this, items) {
            val intent = Intent(this, DetailMatchActivity::class.java)
            intent.putExtra("team", it)
            startActivity(intent)
        }
    }

    companion object {
        var searchCountingIdlingResource = CountingIdlingResource("search")
    }
}