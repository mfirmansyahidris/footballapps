package com.dev.fi.footballapps.ui.favorite

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.data.Team
import com.dev.fi.footballapps.ui.detailTeam.DetailTeamActivity
import com.dev.fi.footballapps.ui.teams.TeamsAdapter
import com.dev.fi.footballapps.utils.dbObject.DataTeams
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import kotlinx.android.synthetic.main.fragment_favorite_teams.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class FavoriteTeamFragment : BaseFragment() {
    private var items: List<Team> = mutableListOf()
    override fun getLayoutResource(): Int = R.layout.fragment_favorite_teams

    override fun mainCode() {
        rv_teams.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_teams.layoutManager = LinearLayoutManager(activity)

        initData()
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    private fun initData() {
        items = emptyList()
        items = DataTeams.getDatas(activity)

        if (items.isEmpty()) {
            tv_msgFavorite.visible()
            rv_teams.invisible()
        } else {
            tv_msgFavorite.invisible()
            rv_teams.visible()
            rv_teams.adapter = TeamsAdapter(activity, items) {
                val intent = Intent(activity, DetailTeamActivity::class.java)
                intent.putExtra("teams", it)
                startActivity(intent)
            }
        }
    }
}