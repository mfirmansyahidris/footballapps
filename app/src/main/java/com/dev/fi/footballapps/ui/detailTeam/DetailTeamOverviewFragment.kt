package com.dev.fi.footballapps.ui.detailTeam

import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.data.Team
import kotlinx.android.synthetic.main.fragment_detail_team_overview.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */
class DetailTeamOverviewFragment : BaseFragment() {
    override fun getLayoutResource(): Int = R.layout.fragment_detail_team_overview

    override fun mainCode() {
        val teams = arguments?.getParcelable<Team>("teams")
        tv_overView.text = teams?.strDescriptionEN
    }

}