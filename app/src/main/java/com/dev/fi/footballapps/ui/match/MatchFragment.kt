package com.dev.fi.footballapps.ui.match

import android.annotation.SuppressLint
import android.content.Intent
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseFragment
import com.dev.fi.footballapps.ui.search.SearchActivity
import com.dev.fi.footballapps.utils.SpinnerListener1
import com.dev.fi.footballapps.utils.SpinnerListener2
import com.dev.fi.footballapps.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_match.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class MatchFragment : BaseFragment() {
    override fun getLayoutResource(): Int = R.layout.fragment_match

    @SuppressLint("RestrictedApi")
    override fun mainCode() {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        viewPagerAdapter.addFragment(MatchPrevFragment())
        viewPagerAdapter.addFragment(MatchNextFragment())
        vp_main.adapter = viewPagerAdapter

        //setup tablayout
        tl_main.setupWithViewPager(vp_main)
        setupTab(getString(R.string.tab_prev), 0) //custom layout
        setupTab(getString(R.string.tab_next), 1) //custom layout

        val leaguesName = resources.getStringArray(R.array.list_leagueName)
        val leaguesId = resources.getStringArray(R.array.list_leagueId)
        val spAdapter: ArrayAdapter<String> = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, leaguesName)
        sp_leagues.adapter = spAdapter

        sp_leagues.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                spinnerListener1?.onItemSelected(leaguesId[position])
                spinnerListener2?.onItemSelected(leaguesId[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        activity.setSupportActionBar(main_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.toolbar_menu_search, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_search -> {
                val intent = Intent(activity, SearchActivity::class.java)
                intent.putExtra("request", "match")
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupTab(title: String, position: Int) {
        val tabHome = LayoutInflater.from(activity).inflate(R.layout.layer_custom_tab, null) as TextView
        tabHome.text = title
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        tl_main.getTabAt(position)?.customView = tabHome
    }

    companion object {
        private var spinnerListener1: SpinnerListener1? = null
        fun setSpinnerListener1(listener: SpinnerListener1) {
            spinnerListener1 = listener
        }

        private var spinnerListener2: SpinnerListener2? = null
        fun setSpinnerListener2(listener: SpinnerListener2) {
            spinnerListener2 = listener
        }
    }

}