package com.dev.fi.footballapps.ui.match

import android.view.LayoutInflater
import android.widget.TextView
import com.dev.fi.footballapps.R
import com.dev.fi.footballschedule2.base.BaseFragment
import com.dev.fi.footballschedule2.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_match.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class MatchFragment: BaseFragment(){
    override fun getLayoutResource(): Int = R.layout.fragment_match

    override fun mainCode() {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.addFragment(MatchPrevFragment())
        viewPagerAdapter.addFragment(MatchNextFragment())
        vp_main.adapter = viewPagerAdapter

        //setup tablayout
        tl_main.setupWithViewPager(vp_main)
        setupTab(getString(R.string.tab_prev), 0) //custom layout
        setupTab(getString(R.string.tab_next), 1) //custom layout
    }

    private fun setupTab(title: String, position: Int) {
        val tabHome = LayoutInflater.from(activity).inflate(R.layout.layer_custom_tab, null) as TextView
        tabHome.text = title
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        tl_main.getTabAt(position)?.customView = tabHome
    }

}