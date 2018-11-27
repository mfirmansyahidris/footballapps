package com.dev.fi.footballapps.ui.detailMatch

import android.view.View
import android.widget.ImageView
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.data.TeamResponse
import com.dev.fi.footballapps.rest.Api
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.ui.detailMatch.DetailMatchActivity.Companion.detailMatchCountingIdlingResouce
import com.dev.fi.footballapps.utils.CoroutineContextProvider
import com.dev.fi.footballapps.utils.invisible
import com.dev.fi.footballapps.utils.visible
import com.google.gson.Gson
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailMatchP(private val view: DetailMatchV, private val repository: Repository,
                   private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getDetail(data: Event) {
        view.showDetail(data)
    }

    fun loadTeamDetail(id: String, placeholder: View, image: ImageView) {
        placeholder.visible()
        detailMatchCountingIdlingResouce.increment()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getTeamDetail(id)).await(),
                    TeamResponse::class.java)

            val url = data.teams[0].strTeamBadge.toString()
            if (url != null) Picasso.get().load(url).into(image, object : Callback {
                override fun onSuccess() {
                    placeholder.invisible()
                }

                override fun onError(e: Exception?) {}
            })
            detailMatchCountingIdlingResouce.decrement()
        }
    }

}