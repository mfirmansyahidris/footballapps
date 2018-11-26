package com.dev.fi.footballapps.ui.detailTeam

import com.dev.fi.footballapps.data.models.Player

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

interface DetailTeamV {
    fun onProcess()
    fun onDone()
    fun showResult(data: List<Player>)
}