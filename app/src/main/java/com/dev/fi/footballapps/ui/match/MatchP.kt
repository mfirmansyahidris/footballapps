package com.dev.fi.footballapps.ui.match

import com.dev.fi.footballapps.data.models.EventResponse
import com.dev.fi.footballapps.data.models.EventsResponse
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

class MatchP(private val view: MatchV,
             private val repository: Repository,
             private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getPrevMatch(id: String) {
        view.onProcess()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getPrevMatch(id)).await(),
                    EventsResponse::class.java)
            if (data.events != null) {
                view.showResult(data.events)
                view.onDone()
            }else{
                view.onEmpyResult()
            }
        }
    }

    fun getNextMatchList(id: String) {
        view.onProcess()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getNextMatch(id)).await(),
                    EventsResponse::class.java)

            if (data.events != null) {
                view.showResult(data.events)
                view.onDone()
            }else{
                view.onEmpyResult()
            }
        }
    }

    fun getSearchMatch(key: String) {
        view.onProcess()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getSearchMatch(key)).await(),
                    EventResponse::class.java)

            if (data.event != null) {
                view.showResult(data.event)
                view.onDone()
            }else{
                view.onEmpyResult()
            }
        }
    }
}