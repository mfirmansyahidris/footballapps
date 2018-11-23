package com.dev.fi.footballapps.rest

import com.orhanobut.logger.Logger
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class Repository {

    fun doRequest(url: String): Deferred<String> = GlobalScope.async {
        Logger.d(url)
        URL(url).readText()
    }
}