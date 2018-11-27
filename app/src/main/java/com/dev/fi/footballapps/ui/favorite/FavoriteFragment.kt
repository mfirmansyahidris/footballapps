package com.dev.fi.footballapps.ui.favorite

import android.view.LayoutInflater
import android.widget.TextView
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_match.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class FavoriteFragment : BaseFragment() {
    override fun getLayoutResource(): Int = R.layout.fragment_favorite

    override fun mainCode() {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.addFragment(FavoriteMatchFragment())
        viewPagerAdapter.addFragment(FavoriteTeamFragment())
        vp_main.adapter = viewPagerAdapter

        //setup tablayout
        tl_main.setupWithViewPager(vp_main)
        setupTab(getString(R.string.tab_match), 0) //custom layout
        setupTab(getString(R.string.tab_team), 1) //custom layout
        activity.setSupportActionBar(main_toolbar)
    }

    private fun setupTab(title: String, position: Int) {
        val tabHome = LayoutInflater.from(activity).inflate(R.layout.layer_custom_tab, null) as TextView
        tabHome.text = title
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        tl_main.getTabAt(position)?.customView = tabHome
    }

}