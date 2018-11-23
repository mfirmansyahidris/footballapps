package com.dev.fi.footballapps.rest

import com.dev.fi.footballapps.BuildConfig


/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

object Api {
    fun getPrevMatch(id: String?): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventspastleague.php?id=" + id
    }

    fun getNextMatch(id: String?): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventsnextleague.php?id=" + id
    }

    fun getSearchMatch(key: String): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/searchevents.php?e=" + key
    }

}
