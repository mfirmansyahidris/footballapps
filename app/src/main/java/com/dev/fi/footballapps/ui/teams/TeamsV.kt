package com.dev.fi.footballapps.ui.teams

import com.dev.fi.footballapps.data.models.Team

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

interface TeamsV {
    fun onProcess()
    fun onDone()
    fun onEmpyResult()
    fun showResult(data: List<Team>)
}