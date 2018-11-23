package com.dev.fi.footballapps.ui.detailMatch

import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseActivity
import com.dev.fi.footballapps.data.models.Event
import com.dev.fi.footballapps.data.tables.FavoriteMatch
import com.dev.fi.footballapps.rest.Repository
import com.dev.fi.footballapps.utils.data.DataFavorite
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

class DetailMatchActivity: BaseActivity(), DetailMatchV{
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
                if (isFavorite) DataFavorite.delete(this, lc_detail, event.idEvent.toString())
                else {
                    val hashMap = LinkedHashMap<String, String?>()
                    hashMap[FavoriteMatch.IDEVENT] = event.idEvent
                    hashMap[FavoriteMatch.IDSOCCERXML] = event.idSoccerXML
                    hashMap[FavoriteMatch.STREVENT] = event.strEvent
                    hashMap[FavoriteMatch.STRFILENAME] = event.strFilename
                    hashMap[FavoriteMatch.STRSPORT] = event.strSport
                    hashMap[FavoriteMatch.IDLEAGUE] = event.idLeague
                    hashMap[FavoriteMatch.STRLEAGUE] = event.strLeague
                    hashMap[FavoriteMatch.STRSEASON] = event.strSeason
                    hashMap[FavoriteMatch.STRDESCRIPTIONEN] = event.strDescriptionEN
                    hashMap[FavoriteMatch.STRHOMETEAM] = event.strHomeTeam
                    hashMap[FavoriteMatch.STRAWAYTEAM] = event.strAwayTeam
                    hashMap[FavoriteMatch.INTHOMESCORE] = event.intHomeScore
                    hashMap[FavoriteMatch.INTROUND] = event.intRound
                    hashMap[FavoriteMatch.INTAWAYSCORE] = event.intAwayScore
                    hashMap[FavoriteMatch.INTSPECTATORS] = event.intSpectators
                    hashMap[FavoriteMatch.STRHOMEGOALDETAILS] = event.strHomeGoalDetails
                    hashMap[FavoriteMatch.STRHOMEREDCARDS] = event.strHomeRedCards
                    hashMap[FavoriteMatch.STRHOMEYELLOWCARDS] = event.strHomeYellowCards
                    hashMap[FavoriteMatch.STRHOMELINEUPGOALKEEPER] = event.strHomeLineupGoalkeeper
                    hashMap[FavoriteMatch.STRHOMELINEUPDEFENSE] = event.strHomeLineupDefense
                    hashMap[FavoriteMatch.STRHOMELINEUPMIDFIELD] = event.strHomeLineupMidfield
                    hashMap[FavoriteMatch.STRHOMELINEUPFORWARD] = event.strHomeLineupForward
                    hashMap[FavoriteMatch.STRHOMELINEUPSUBSTITUTES] = event.strHomeLineupSubstitutes
                    hashMap[FavoriteMatch.STRHOMEFORMATION] = event.strHomeFormation
                    hashMap[FavoriteMatch.STRAWAYREDCARDS] = event.strAwayRedCards
                    hashMap[FavoriteMatch.STRAWAYYELLOWCARDS] = event.strAwayYellowCards
                    hashMap[FavoriteMatch.STRAWAYGOALDETAILS] = event.strAwayGoalDetails
                    hashMap[FavoriteMatch.STRAWAYLINEUPGOALKEEPER] = event.strAwayLineupGoalkeeper
                    hashMap[FavoriteMatch.STRAWAYLINEUPDEFENSE] = event.strAwayLineupDefense
                    hashMap[FavoriteMatch.STRAWAYLINEUPMIDFIELD] = event.strAwayLineupMidfield
                    hashMap[FavoriteMatch.STRAWAYLINEUPFORWARD] = event.strAwayLineupForward
                    hashMap[FavoriteMatch.STRAWAYLINEUPSUBSTITUTES] = event.strAwayLineupSubstitutes
                    hashMap[FavoriteMatch.STRAWAYFORMATION] = event.strAwayFormation
                    hashMap[FavoriteMatch.INTHOMESHOTS] = event.intHomeShots
                    hashMap[FavoriteMatch.INTAWAYSHOTS] = event.intAwayShots
                    hashMap[FavoriteMatch.DATEEVENT] = event.dateEvent
                    hashMap[FavoriteMatch.STRDATE] = event.strDate
                    hashMap[FavoriteMatch.STRTIME] = event.strTime
                    hashMap[FavoriteMatch.STRTVSTATION] = event.strTVStation
                    hashMap[FavoriteMatch.IDHOMETEAM] = event.idHomeTeam
                    hashMap[FavoriteMatch.IDAWAYTEAM] = event.idAwayTeam
                    hashMap[FavoriteMatch.STRRESULT] = event.strResult
                    hashMap[FavoriteMatch.STRCIRCUIT] = event.strCircuit
                    hashMap[FavoriteMatch.STRCOUNTRY] = event.strCountry
                    hashMap[FavoriteMatch.STRCITY] = event.strCity
                    hashMap[FavoriteMatch.STRPOSTER] = event.strPoster
                    hashMap[FavoriteMatch.STRFANART] = event.strFanart
                    hashMap[FavoriteMatch.STRTHUMB] = event.strThumb
                    hashMap[FavoriteMatch.STRBANNER] = event.strBanner
                    hashMap[FavoriteMatch.STRMAP] = event.strMap
                    hashMap[FavoriteMatch.STRLOCKED] = event.strLocked

                    DataFavorite.insert(this, lc_detail, hashMap)
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

    private fun favoriteState(){
        val favorite = DataFavorite.getDataById(this, event.idEvent.toString())
        if (!favorite.isEmpty()) isFavorite = true
    }

}