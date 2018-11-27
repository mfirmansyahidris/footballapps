package com.dev.fi.footballapps.ui.detailTeam

import com.dev.fi.footballapps.data.PlayerResponse
import com.dev.fi.footballapps.rest.Api
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.utils.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailTeamP(private val view: DetailTeamV,
                  private val repository: Repository,
                  private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getPlayers(team: String) {
        view.onProcess()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getPlayers(team)).await(),
                    PlayerResponse::class.java)
            if (data.player != null) {
                view.showResult(data.player)
                view.onDone()
            }
        }
    }
}