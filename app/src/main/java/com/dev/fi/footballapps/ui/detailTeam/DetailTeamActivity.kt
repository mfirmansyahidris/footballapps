package com.dev.fi.footballapps.ui.detailTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseActivity
import com.dev.fi.footballapps.data.models.Team
import com.dev.fi.footballapps.utils.ViewPagerAdapter
import com.dev.fi.footballapps.utils.invisible
import com.orhanobut.logger.Logger
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*
import kotlinx.android.synthetic.main.toolbar_image.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailTeamActivity : BaseActivity() {
    lateinit var team: Team
    override fun getLayoutResource(): Int = R.layout.activity_detail_team

    override fun getToolbarResource(): Int = R.id.toolbar_image

    override fun getToolbarTitle(): String = ""

    override fun mainCode() {
        team = intent.getParcelableExtra("teams")
        val bundle = Bundle()
        bundle.putParcelable("teams", team)

        if (team.strTeamBadge != null) Picasso.get().load(team.strTeamBadge).into(iv_logo, object : Callback {
            override fun onSuccess() { pb_placeholder.invisible()}
            override fun onError(e: Exception?) {}
        })

        tv_strTeam.text = team.strTeam
        tv_strStadium.text = team.strStadium
        tv_intFormedYear.text = team.intFormedYear

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        val detailTeamOverviewFragment = DetailTeamOverviewFragment()
        val detailTeamPlayerFragment = DetailTeamPlayerFragment()
        detailTeamOverviewFragment.arguments = bundle
        detailTeamPlayerFragment.arguments = bundle

        viewPagerAdapter.addFragment(detailTeamOverviewFragment)
        viewPagerAdapter.addFragment(detailTeamPlayerFragment)
        vp_main.adapter = viewPagerAdapter

        tl_main.setupWithViewPager(vp_main)
        setupTab(getString(R.string.tab_overview), 0) //custom layout
        setupTab(getString(R.string.tab_player), 1) //custom layout`

    }

    private fun setupTab(title: String, position: Int) {
        val tabHome = LayoutInflater.from(this).inflate(R.layout.layer_custom_tab, null) as TextView
        tabHome.text = title
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        tl_main.getTabAt(position)?.customView = tabHome
    }

}