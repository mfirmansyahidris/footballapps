package com.dev.fi.footballschedule2.rest

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
        URL(url).readText()
    }
}