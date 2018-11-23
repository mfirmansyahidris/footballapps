package com.dev.fi.footballapps.ui

import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.ui.favorite.FavoriteFragment
import com.dev.fi.footballapps.ui.match.MatchFragment
import com.dev.fi.footballschedule2.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun getLayoutResource(): Int = R.layout.activity_home

    override fun getToolbarResource(): Int = 0

    override fun getToolbarTitle(): String = ""

    override fun mainCode() {
        bn_menu.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navmenu_match -> openFragment(MatchFragment(), getString(R.string.menu_match))
                R.id.navmenu_teams -> openFragment(TeamsFragment(), getString(R.string.menu_teams))
                R.id.navmenu_favorites -> openFragment(FavoriteFragment(), getString(R.string.menu_favorites))
            }
            true
        }
        bn_menu.selectedItemId = R.id.navmenu_match
    }

    private fun openFragment(fragment: Fragment, title: String) {
        supportActionBar?.subtitle = title
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_container, fragment)
        ft.commit()
    }
}
