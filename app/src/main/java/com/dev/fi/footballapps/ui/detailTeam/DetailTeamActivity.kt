package com.dev.fi.footballapps.ui.detailTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.test.espresso.idling.CountingIdlingResource
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseActivity
import com.dev.fi.footballapps.data.Team
import com.dev.fi.footballapps.utils.ViewPagerAdapter
import com.dev.fi.footballapps.utils.dbObject.DataTeams
import com.dev.fi.footballapps.utils.invisible
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
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    override fun getLayoutResource(): Int = R.layout.activity_detail_team

    override fun getToolbarResource(): Int = R.id.toolbar_image

    override fun getToolbarTitle(): String = ""

    override fun mainCode() {
        team = intent.getParcelableExtra("teams")
        val bundle = Bundle()
        bundle.putParcelable("teams", team)

        if (team.strTeamBadge != null) Picasso.get().load(team.strTeamBadge).into(iv_logo, object : Callback {
            override fun onSuccess() {
                pb_placeholder.invisible()
            }

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

        favoriteState()

    }

    private fun setupTab(title: String, position: Int) {
        val tabHome = LayoutInflater.from(this).inflate(R.layout.layer_custom_tab, null) as TextView
        tabHome.text = title
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        tl_main.getTabAt(position)?.customView = tabHome
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toobar_menu_detail, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.add_to_favorite -> {
                if (isFavorite) DataTeams.delete(this, cl_detail, team.idTeam.toString())
                else {
                    val hashMap = LinkedHashMap<String, String?>()
                    hashMap[Team.IDTEAM] = team.idTeam
                    hashMap[Team.IDSOCCERXML] = team.idSoccerXML
                    hashMap[Team.INTLOVED] = team.intLoved
                    hashMap[Team.STRTEAM] = team.strTeam
                    hashMap[Team.STRTEAMSHORT] = team.strTeamShort
                    hashMap[Team.STRALTERNATE] = team.strAlternate
                    hashMap[Team.INTFORMEDYEAR] = team.intFormedYear
                    hashMap[Team.STRSPORT] = team.strSport
                    hashMap[Team.STRLEAGUE] = team.strLeague
                    hashMap[Team.IDLEAGUE] = team.idLeague
                    hashMap[Team.STRDIVISION] = team.strDivision
                    hashMap[Team.STRMANAGER] = team.strManager
                    hashMap[Team.STRSTADIUM] = team.strStadium
                    hashMap[Team.STRKEYWORDS] = team.strKeywords
                    hashMap[Team.STRRSS] = team.strRSS
                    hashMap[Team.STRSTADIUMTHUMB] = team.strStadiumThumb
                    hashMap[Team.STRSTADIUMDESCRIPTION] = team.strStadiumDescription
                    hashMap[Team.STRSTADIUMLOCATION] = team.strStadiumLocation
                    hashMap[Team.INTSTADIUMCAPACITY] = team.intStadiumCapacity
                    hashMap[Team.STRWEBSITE] = team.strWebsite
                    hashMap[Team.STRFACEBOOK] = team.strFacebook
                    hashMap[Team.STRTWITTER] = team.strTwitter
                    hashMap[Team.STRINSTAGRAM] = team.strInstagram
                    hashMap[Team.STRDESCRIPTIONEN] = team.strDescriptionEN
                    hashMap[Team.STRDESCRIPTIONDE] = team.strDescriptionDE
                    hashMap[Team.STRDESCRIPTIONFR] = team.strDescriptionFR
                    hashMap[Team.STRDESCRIPTIONCN] = team.strDescriptionCN
                    hashMap[Team.STRDESCRIPTIONIT] = team.strDescriptionIT
                    hashMap[Team.STRDESCRIPTIONJP] = team.strDescriptionJP
                    hashMap[Team.STRDESCRIPTIONRU] = team.strDescriptionRU
                    hashMap[Team.STRDESCRIPTIONES] = team.strDescriptionES
                    hashMap[Team.STRDESCRIPTIONPT] = team.strDescriptionPT
                    hashMap[Team.STRDESCRIPTIONSE] = team.strDescriptionSE
                    hashMap[Team.STRDESCRIPTIONNL] = team.strDescriptionNL
                    hashMap[Team.STRDESCRIPTIONHU] = team.strDescriptionHU
                    hashMap[Team.STRDESCRIPTIONNO] = team.strDescriptionNO
                    hashMap[Team.STRDESCRIPTIONIL] = team.strDescriptionIL
                    hashMap[Team.STRDESCRIPTIONPL] = team.strDescriptionPL
                    hashMap[Team.STRGENDER] = team.strGender
                    hashMap[Team.STRCOUNTRY] = team.strCountry
                    hashMap[Team.STRTEAMBADGE] = team.strTeamBadge
                    hashMap[Team.STRTEAMJERSEY] = team.strTeamJersey
                    hashMap[Team.STRTEAMLOGO] = team.strTeamLogo
                    hashMap[Team.STRTEAMFANART1] = team.strTeamFanart1
                    hashMap[Team.STRTEAMFANART2] = team.strTeamFanart2
                    hashMap[Team.STRTEAMFANART3] = team.strTeamFanart3
                    hashMap[Team.STRTEAMFANART4] = team.strTeamFanart4
                    hashMap[Team.STRTEAMBANNER] = team.strTeamBanner
                    hashMap[Team.STRYOUTUBE] = team.strYoutube
                    hashMap[Team.STRLOCKED] = team.strLocked

                    DataTeams.insert(this, cl_detail, hashMap)
                }

                isFavorite = !isFavorite
                setFavorite()

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_black_24dp)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_border_black_24dp)
    }

    private fun favoriteState() {
        val favorite = DataTeams.getDataById(this, team.idTeam.toString())
        if (!favorite.isEmpty()) isFavorite = true
    }

    companion object {
        var playerCountingIdlingResource = CountingIdlingResource("detailTeam")
    }


}