package com.dev.fi.footballapps.utils.dbObject

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.view.View
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.data.Team
import com.dev.fi.footballapps.utils.database
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

object DataTeams {
    fun getDatas(context: Context): List<Team> {
        var items: List<Team> = mutableListOf()
        context.database.use {
            val result = select(Team.TABLE_TEAMS)
            items = result.parseList(classParser())
        }
        return items
    }

    fun getDataById(context: Context, byId: String): List<Team> {
        var items: List<Team> = mutableListOf()
        context.database.use {
            val result = select(Team.TABLE_TEAMS).whereArgs("${Team.IDTEAM} = '$byId'")
            items = result.parseList(classParser())
        }
        return items
    }


    fun insert(context: Context, view: View, hashMap: LinkedHashMap<String, String?>) {
        try {
            context.database.use {
                insert(Team.TABLE_TEAMS,
                        Team.IDTEAM to hashMap[Team.IDTEAM],
                            Team.IDSOCCERXML to hashMap[Team.IDSOCCERXML],
                            Team.INTLOVED to hashMap[Team.INTLOVED],
                            Team.STRTEAM to hashMap[Team.STRTEAM],
                            Team.STRTEAMSHORT to hashMap[Team.STRTEAMSHORT],
                            Team.STRALTERNATE to hashMap[Team.STRALTERNATE],
                            Team.INTFORMEDYEAR to hashMap[Team.INTFORMEDYEAR],
                            Team.STRSPORT to hashMap[Team.STRSPORT],
                            Team.STRLEAGUE to hashMap[Team.STRLEAGUE],
                            Team.IDLEAGUE to hashMap[Team.IDLEAGUE],
                            Team.STRDIVISION to hashMap[Team.STRDIVISION],
                            Team.STRMANAGER to hashMap[Team.STRMANAGER],
                            Team.STRSTADIUM to hashMap[Team.STRSTADIUM],
                            Team.STRKEYWORDS to hashMap[Team.STRKEYWORDS],
                            Team.STRRSS to hashMap[Team.STRRSS],
                            Team.STRSTADIUMTHUMB to hashMap[Team.STRSTADIUMTHUMB],
                            Team.STRSTADIUMDESCRIPTION to hashMap[Team.STRSTADIUMDESCRIPTION],
                            Team.STRSTADIUMLOCATION to hashMap[Team.STRSTADIUMLOCATION],
                            Team.INTSTADIUMCAPACITY to hashMap[Team.INTSTADIUMCAPACITY],
                            Team.STRWEBSITE to hashMap[Team.STRWEBSITE],
                            Team.STRFACEBOOK to hashMap[Team.STRFACEBOOK],
                            Team.STRTWITTER to hashMap[Team.STRTWITTER],
                            Team.STRINSTAGRAM to hashMap[Team.STRINSTAGRAM],
                            Team.STRDESCRIPTIONEN to hashMap[Team.STRDESCRIPTIONEN],
                            Team.STRDESCRIPTIONDE to hashMap[Team.STRDESCRIPTIONDE],
                            Team.STRDESCRIPTIONFR to hashMap[Team.STRDESCRIPTIONFR],
                            Team.STRDESCRIPTIONCN to hashMap[Team.STRDESCRIPTIONCN],
                            Team.STRDESCRIPTIONIT to hashMap[Team.STRDESCRIPTIONIT],
                            Team.STRDESCRIPTIONJP to hashMap[Team.STRDESCRIPTIONJP],
                            Team.STRDESCRIPTIONRU to hashMap[Team.STRDESCRIPTIONRU],
                            Team.STRDESCRIPTIONES to hashMap[Team.STRDESCRIPTIONES],
                            Team.STRDESCRIPTIONPT to hashMap[Team.STRDESCRIPTIONPT],
                            Team.STRDESCRIPTIONSE to hashMap[Team.STRDESCRIPTIONSE],
                            Team.STRDESCRIPTIONNL to hashMap[Team.STRDESCRIPTIONNL],
                            Team.STRDESCRIPTIONHU to hashMap[Team.STRDESCRIPTIONHU],
                            Team.STRDESCRIPTIONNO to hashMap[Team.STRDESCRIPTIONNO],
                            Team.STRDESCRIPTIONIL to hashMap[Team.STRDESCRIPTIONIL],
                            Team.STRDESCRIPTIONPL to hashMap[Team.STRDESCRIPTIONPL],
                            Team.STRGENDER to hashMap[Team.STRGENDER],
                            Team.STRCOUNTRY to hashMap[Team.STRCOUNTRY],
                            Team.STRTEAMBADGE to hashMap[Team.STRTEAMBADGE],
                            Team.STRTEAMJERSEY to hashMap[Team.STRTEAMJERSEY],
                            Team.STRTEAMLOGO to hashMap[Team.STRTEAMLOGO],
                            Team.STRTEAMFANART1 to hashMap[Team.STRTEAMFANART1],
                            Team.STRTEAMFANART2 to hashMap[Team.STRTEAMFANART2],
                            Team.STRTEAMFANART3 to hashMap[Team.STRTEAMFANART3],
                            Team.STRTEAMFANART4 to hashMap[Team.STRTEAMFANART4],
                            Team.STRTEAMBANNER to hashMap[Team.STRTEAMBANNER],
                            Team.STRYOUTUBE to hashMap[Team.STRYOUTUBE],
                            Team.STRLOCKED to hashMap[Team.STRLOCKED]
                )
            }
            Snackbar.make(view, context.getText(R.string.msg_addToFavorite), Snackbar.LENGTH_LONG).show()
        } catch (e: SQLiteConstraintException) {
            Snackbar.make(view, e.localizedMessage, Snackbar.LENGTH_LONG).show()
        }
    }

    fun delete(context: Context, view: View, id: String) {
        try {
            context.database.use {
                delete(Team.TABLE_TEAMS, "(IDTEAM= {id})",
                        "id" to id)
            }
            Snackbar.make(view, context.getString(R.string.msg_removeFromFavorite), Snackbar.LENGTH_LONG).show()
        } catch (e: SQLiteConstraintException) {
            Snackbar.make(view, e.localizedMessage, Snackbar.LENGTH_LONG).show()
        }
    }
}