package com.dev.fi.footballapps.ui.match

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseActivity
import com.dev.fi.footballapps.data.models.Event
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_match_search.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class MatchSearchActivity : BaseActivity(), MatchV {
    private var items: MutableList<Event> = mutableListOf()
    private lateinit var presenter: MatchP
    override fun getLayoutResource(): Int = R.layout.activity_match_search

    override fun getToolbarResource(): Int = R.id.main_toolbar

    override fun getToolbarTitle(): String = ""

    @SuppressLint("RestrictedApi")
    override fun mainCode() {
        rv_searchResult.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_searchResult.layoutManager = LinearLayoutManager(this)

        val request = Repository()
        val gson = Gson()
        presenter = MatchP(this, request, gson)

        sv_match.onActionViewExpanded()
        sv_match.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.length!! > 3) {
                    Log.d("Tagg", newText)
                    presenter.getSearchMatch(newText)
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
        pb_process.visible()
        rv_searchResult.invisible()
        tv_listMessage.invisible()
    }

    override fun onDone() {
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

    override fun showResult(data: List<Event>) {
        items.clear()
        items.addAll(data)
        rv_searchResult.adapter = MatchAdapter(this, items) {
            val intent = Intent(this, DetailMatchActivity::class.java)
            intent.putExtra("event", it)
            startActivity(intent)
        }
    }
}