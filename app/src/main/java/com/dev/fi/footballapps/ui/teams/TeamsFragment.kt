package com.dev.fi.footballapps.ui.teams

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.data.Team
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.ui.detailTeam.DetailTeamActivity
import com.dev.fi.footballapps.ui.search.SearchActivity
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_teams.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class TeamsFragment: BaseFragment(), TeamsV{
    private var items: MutableList<Team> = mutableListOf()
    private lateinit var presenter: TeamsP
    override fun getLayoutResource(): Int = R.layout.fragment_teams

    override fun mainCode() {
        rv_teams.id = R.id.rv_match_prev
        rv_teams.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_teams.layoutManager = LinearLayoutManager(activity)

        val request = Repository()
        val gson = Gson()
        presenter = TeamsP(this, request, gson)

        val leaguesName = resources.getStringArray(R.array.list_leagueName)
        val leaguesId = resources.getStringArray(R.array.list_leagueId)
        val spAdapter: ArrayAdapter<String> = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, leaguesName)
        sp_leagues.adapter = spAdapter

        sp_leagues.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                presenter.getTeams(leaguesId[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        activity.setSupportActionBar(main_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.toolbar_menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_search -> {
                val intent = Intent(activity, SearchActivity::class.java)
                intent.putExtra("request", "teams")
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onProcess() {
        rv_teams.invisible()
        pb_process.visible()
    }

    override fun onDone() {
        rv_teams.visible()
        pb_process.invisible()
    }

    override fun showResult(data: List<Team>) {
        items.clear()
        items.addAll(data)
        rv_teams.adapter = TeamsAdapter(activity, items) {
            val intent = Intent(activity, DetailTeamActivity::class.java)
            intent.putExtra("teams", it)
            startActivity(intent)
        }
    }

}