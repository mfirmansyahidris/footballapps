package com.dev.fi.footballapps.ui.detailTeam

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.data.Player
import com.dev.fi.footballapps.data.Team
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_detail_team_players.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailTeamPlayerFragment : BaseFragment(), DetailTeamV {
    private var items: MutableList<Player> = mutableListOf()
    private lateinit var presenter: DetailTeamP

    override fun getLayoutResource(): Int = R.layout.fragment_detail_team_players

    override fun mainCode() {
        rv_players.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_players.layoutManager = LinearLayoutManager(activity)

        val request = Repository()
        val gson = Gson()
        presenter = DetailTeamP(this, request, gson)

        val teams = arguments?.getParcelable<Team>("teams")
        presenter.getPlayers(teams?.idTeam.toString())
    }

    override fun onProcess() {
        rv_players.invisible()
        pb_process.visible()
    }

    override fun onDone() {
        rv_players.visible()
        pb_process.invisible()
    }

    override fun showResult(data: List<Player>) {
        items.clear()
        items.addAll(data)
        rv_players.adapter = DetailTeamPlayerAdapter(activity, items) {
            val intent = Intent(activity, DetailPlayerActivity::class.java)
            intent.putExtra("player", it)
            startActivity(intent)
        }
    }
}