package com.dev.fi.footballapps.ui.match

import com.dev.fi.footballschedule2.data.model.Event

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

interface MatchV {
    fun onProcess()
    fun onDone()
    fun showResult(data: List<Event>)
}