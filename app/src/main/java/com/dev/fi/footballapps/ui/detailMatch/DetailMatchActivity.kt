package com.dev.fi.footballapps.ui.detailMatch

import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.test.espresso.idling.CountingIdlingResource
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseActivity
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.utils.dbObject.DataEvent
import com.dev.fi.footballapps.utils.lineText
import com.dev.fi.footballapps.utils.reformatDate
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail_match.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailMatchActivity : BaseActivity(), DetailMatchV {
    private lateinit var presenter: DetailMatchP
    private var menuItem: Menu? = null
    private lateinit var event: Event
    private var isFavorite: Boolean = false

    override fun getLayoutResource(): Int = R.layout.activity_detail_match

    override fun getToolbarResource(): Int = R.id.main_toolbar

    override fun getToolbarTitle(): String = getString(R.string.title_detailMatch)

    override fun mainCode() {
        val request = Repository()
        val gson = Gson()

        presenter = DetailMatchP(this, request, gson)

        event = intent.getParcelableExtra("event")
        presenter.getDetail(event)

        favoriteState()
    }

    override fun showDetail(data: Event) {
        presenter.loadTeamDetail(data.idHomeTeam.toString(), pb_homePlaceholder, iv_logoHome)
        presenter.loadTeamDetail(data.idAwayTeam.toString(), pb_awayPlaceholder, iv_logoAway)

        tv_dateEvent.text = reformatDate(data.dateEvent)
        tv_strHomeTeam.text = data.strHomeTeam
        tv_intHomeScore.text = data.intHomeScore
        tv_intAwayScore.text = data.intAwayScore
        tv_strAwayTeam.text = data.strAwayTeam
        tv_strHomeGoalDetails.text = lineText(data.strHomeGoalDetails)
        tv_strAwayGoalDetails.text = lineText(data.strAwayGoalDetails)
        tv_intHomeShots.text = lineText(data.intHomeShots)
        tv_intAwayShots.text = lineText(data.intAwayShots)
        tv_strHomeLinepupGoalkeeper.text = lineText(data.strHomeLineupGoalkeeper)
        tv_strAwayLineupGoalkeeper.text = lineText(data.strAwayLineupGoalkeeper)
        tv_strHomeLineupDefense.text = lineText(data.strHomeLineupDefense)
        tv_strAwayLineupDefense.text = lineText(data.strAwayLineupDefense)
        tv_strHomeLineupMidfield.text = lineText(data.strHomeLineupMidfield)
        tv_strAwayLineupMidfield.text = lineText(data.strAwayLineupMidfield)
        tv_strHomeLineupForward.text = lineText(data.strHomeLineupForward)
        tv_strAwayLineupForward.text = lineText(data.strAwayLineupForward)
        tv_strHomeLineupSubstitutes.text = lineText(data.strHomeLineupSubstitutes)
        tv_strAwayLineupSubstitutes.text = lineText(data.strAwayLineupSubstitutes)
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
                if (isFavorite) DataEvent.delete(this, lc_detail, event.idEvent.toString())
                else {
                    val hashMap = LinkedHashMap<String, String?>()
                    hashMap[Event.IDEVENT] = event.idEvent
                    hashMap[Event.IDSOCCERXML] = event.idSoccerXML
                    hashMap[Event.STREVENT] = event.strEvent
                    hashMap[Event.STRFILENAME] = event.strFilename
                    hashMap[Event.STRSPORT] = event.strSport
                    hashMap[Event.IDLEAGUE] = event.idLeague
                    hashMap[Event.STRLEAGUE] = event.strLeague
                    hashMap[Event.STRSEASON] = event.strSeason
                    hashMap[Event.STRDESCRIPTIONEN] = event.strDescriptionEN
                    hashMap[Event.STRHOMETEAM] = event.strHomeTeam
                    hashMap[Event.STRAWAYTEAM] = event.strAwayTeam
                    hashMap[Event.INTHOMESCORE] = event.intHomeScore
                    hashMap[Event.INTROUND] = event.intRound
                    hashMap[Event.INTAWAYSCORE] = event.intAwayScore
                    hashMap[Event.INTSPECTATORS] = event.intSpectators
                    hashMap[Event.STRHOMEGOALDETAILS] = event.strHomeGoalDetails
                    hashMap[Event.STRHOMEREDCARDS] = event.strHomeRedCards
                    hashMap[Event.STRHOMEYELLOWCARDS] = event.strHomeYellowCards
                    hashMap[Event.STRHOMELINEUPGOALKEEPER] = event.strHomeLineupGoalkeeper
                    hashMap[Event.STRHOMELINEUPDEFENSE] = event.strHomeLineupDefense
                    hashMap[Event.STRHOMELINEUPMIDFIELD] = event.strHomeLineupMidfield
                    hashMap[Event.STRHOMELINEUPFORWARD] = event.strHomeLineupForward
                    hashMap[Event.STRHOMELINEUPSUBSTITUTES] = event.strHomeLineupSubstitutes
                    hashMap[Event.STRHOMEFORMATION] = event.strHomeFormation
                    hashMap[Event.STRAWAYREDCARDS] = event.strAwayRedCards
                    hashMap[Event.STRAWAYYELLOWCARDS] = event.strAwayYellowCards
                    hashMap[Event.STRAWAYGOALDETAILS] = event.strAwayGoalDetails
                    hashMap[Event.STRAWAYLINEUPGOALKEEPER] = event.strAwayLineupGoalkeeper
                    hashMap[Event.STRAWAYLINEUPDEFENSE] = event.strAwayLineupDefense
                    hashMap[Event.STRAWAYLINEUPMIDFIELD] = event.strAwayLineupMidfield
                    hashMap[Event.STRAWAYLINEUPFORWARD] = event.strAwayLineupForward
                    hashMap[Event.STRAWAYLINEUPSUBSTITUTES] = event.strAwayLineupSubstitutes
                    hashMap[Event.STRAWAYFORMATION] = event.strAwayFormation
                    hashMap[Event.INTHOMESHOTS] = event.intHomeShots
                    hashMap[Event.INTAWAYSHOTS] = event.intAwayShots
                    hashMap[Event.DATEEVENT] = event.dateEvent
                    hashMap[Event.STRDATE] = event.strDate
                    hashMap[Event.STRTIME] = event.strTime
                    hashMap[Event.STRTVSTATION] = event.strTVStation
                    hashMap[Event.IDHOMETEAM] = event.idHomeTeam
                    hashMap[Event.IDAWAYTEAM] = event.idAwayTeam
                    hashMap[Event.STRRESULT] = event.strResult
                    hashMap[Event.STRCIRCUIT] = event.strCircuit
                    hashMap[Event.STRCOUNTRY] = event.strCountry
                    hashMap[Event.STRCITY] = event.strCity
                    hashMap[Event.STRPOSTER] = event.strPoster
                    hashMap[Event.STRFANART] = event.strFanart
                    hashMap[Event.STRTHUMB] = event.strThumb
                    hashMap[Event.STRBANNER] = event.strBanner
                    hashMap[Event.STRMAP] = event.strMap
                    hashMap[Event.STRLOCKED] = event.strLocked

                    DataEvent.insert(this, lc_detail, hashMap)
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
        val favorite = DataEvent.getDataById(this, event.idEvent.toString())
        if (!favorite.isEmpty()) isFavorite = true
    }

    companion object {
        var detailMatchCountingIdlingResouce = CountingIdlingResource("detail_match")
    }

}