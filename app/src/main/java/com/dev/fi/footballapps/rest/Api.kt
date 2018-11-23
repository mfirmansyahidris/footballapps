package com.dev.fi.footballschedule2.rest

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

}
