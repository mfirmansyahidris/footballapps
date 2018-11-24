package com.dev.fi.footballapps.ui.teams

import com.dev.fi.footballapps.data.models.TeamResponse
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

class TeamsP(private val view: TeamsV,
             private val repository: Repository,
             private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeams(id: String) {
        view.onProcess()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getTeams(id)).await(),
                    TeamResponse::class.java)
            if (data.teams != null) {
                view.showResult(data.teams)
                view.onDone()
            }else{
                view.onEmpyResult()
            }
        }
    }
}