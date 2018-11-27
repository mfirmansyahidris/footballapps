package com.dev.fi.footballapps.ui.search

import com.dev.fi.footballapps.data.EventResponse
import com.dev.fi.footballapps.data.TeamResponse
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

class SearchP(private val view: SearchV,
              private val repository: Repository,
              private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getSearchMatch(key: String) {
        view.onProcess()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getSearchMatch(key)).await(),
                    EventResponse::class.java)

            if (data.event != null) {
                view.showResult(data.event)
                view.onDone()
            } else {
                view.onEmpyResult()
            }
        }
    }

    fun getSearchTeam(key: String) {
        view.onProcess()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getSearchTeam(key)).await(),
                    TeamResponse::class.java)

            if (data.teams != null) {
                view.showResult(data.teams)
                view.onDone()
            } else {
                view.onEmpyResult()
            }
        }
    }
}