package com.dev.fi.footballapps.utils.data

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.view.View
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.data.models.Event
import com.dev.fi.footballapps.data.tables.FavoriteMatch
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

object DataFavorite {
    fun getDatas(context: Context): List<Event> {
        var items: List<Event> = mutableListOf()
        context.database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE)
            items = result.parseList(classParser())
        }
        return items
    }

    fun getDataById(context: Context, byId: String): List<Event> {
        var items: List<Event> = mutableListOf()
        context.database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE).whereArgs("${FavoriteMatch.IDEVENT} = '$byId'")
            items = result.parseList(classParser())
        }
        return items
    }


    fun insert(context: Context, view: View, hashMap: LinkedHashMap<String, String?>) {
        try {
            context.database.use {
                insert(FavoriteMatch.TABLE_FAVORITE,
                        FavoriteMatch.IDEVENT to hashMap[FavoriteMatch.IDEVENT],
                        FavoriteMatch.IDSOCCERXML to hashMap[FavoriteMatch.IDSOCCERXML],
                        FavoriteMatch.STREVENT to hashMap[FavoriteMatch.STREVENT],
                        FavoriteMatch.STRFILENAME to hashMap[FavoriteMatch.STRFILENAME],
                        FavoriteMatch.STRSPORT to hashMap[FavoriteMatch.STRSPORT],
                        FavoriteMatch.IDLEAGUE to hashMap[FavoriteMatch.IDLEAGUE],
                        FavoriteMatch.STRLEAGUE to hashMap[FavoriteMatch.STRLEAGUE],
                        FavoriteMatch.STRSEASON to hashMap[FavoriteMatch.STRSEASON],
                        FavoriteMatch.STRDESCRIPTIONEN to hashMap[FavoriteMatch.STRDESCRIPTIONEN],
                        FavoriteMatch.STRHOMETEAM to hashMap[FavoriteMatch.STRHOMETEAM],
                        FavoriteMatch.STRAWAYTEAM to hashMap[FavoriteMatch.STRAWAYTEAM],
                        FavoriteMatch.INTHOMESCORE to hashMap[FavoriteMatch.INTHOMESCORE],
                        FavoriteMatch.INTROUND to hashMap[FavoriteMatch.INTROUND],
                        FavoriteMatch.INTAWAYSCORE to hashMap[FavoriteMatch.INTAWAYSCORE],
                        FavoriteMatch.INTSPECTATORS to hashMap[FavoriteMatch.INTSPECTATORS],
                        FavoriteMatch.STRHOMEGOALDETAILS to hashMap[FavoriteMatch.STRHOMEGOALDETAILS],
                        FavoriteMatch.STRHOMEREDCARDS to hashMap[FavoriteMatch.STRHOMEREDCARDS],
                        FavoriteMatch.STRHOMEYELLOWCARDS to hashMap[FavoriteMatch.STRHOMEYELLOWCARDS],
                        FavoriteMatch.STRHOMELINEUPGOALKEEPER to hashMap[FavoriteMatch.STRHOMELINEUPGOALKEEPER],
                        FavoriteMatch.STRHOMELINEUPDEFENSE to hashMap[FavoriteMatch.STRHOMELINEUPDEFENSE],
                        FavoriteMatch.STRHOMELINEUPMIDFIELD to hashMap[FavoriteMatch.STRHOMELINEUPMIDFIELD],
                        FavoriteMatch.STRHOMELINEUPFORWARD to hashMap[FavoriteMatch.STRHOMELINEUPFORWARD],
                        FavoriteMatch.STRHOMELINEUPSUBSTITUTES to hashMap[FavoriteMatch.STRHOMELINEUPSUBSTITUTES],
                        FavoriteMatch.STRHOMEFORMATION to hashMap[FavoriteMatch.STRHOMEFORMATION],
                        FavoriteMatch.STRAWAYREDCARDS to hashMap[FavoriteMatch.STRAWAYREDCARDS],
                        FavoriteMatch.STRAWAYYELLOWCARDS to hashMap[FavoriteMatch.STRAWAYYELLOWCARDS],
                        FavoriteMatch.STRAWAYGOALDETAILS to hashMap[FavoriteMatch.STRAWAYGOALDETAILS],
                        FavoriteMatch.STRAWAYLINEUPGOALKEEPER to hashMap[FavoriteMatch.STRAWAYLINEUPGOALKEEPER],
                        FavoriteMatch.STRAWAYLINEUPDEFENSE to hashMap[FavoriteMatch.STRAWAYLINEUPDEFENSE],
                        FavoriteMatch.STRAWAYLINEUPMIDFIELD to hashMap[FavoriteMatch.STRAWAYLINEUPMIDFIELD],
                        FavoriteMatch.STRAWAYLINEUPFORWARD to hashMap[FavoriteMatch.STRAWAYLINEUPFORWARD],
                        FavoriteMatch.STRAWAYLINEUPSUBSTITUTES to hashMap[FavoriteMatch.STRAWAYLINEUPSUBSTITUTES],
                        FavoriteMatch.STRAWAYFORMATION to hashMap[FavoriteMatch.STRAWAYFORMATION],
                        FavoriteMatch.INTHOMESHOTS to hashMap[FavoriteMatch.INTHOMESHOTS],
                        FavoriteMatch.INTAWAYSHOTS to hashMap[FavoriteMatch.INTAWAYSHOTS],
                        FavoriteMatch.DATEEVENT to hashMap[FavoriteMatch.DATEEVENT],
                        FavoriteMatch.STRDATE to hashMap[FavoriteMatch.STRDATE],
                        FavoriteMatch.STRTIME to hashMap[FavoriteMatch.STRTIME],
                        FavoriteMatch.STRTVSTATION to hashMap[FavoriteMatch.STRTVSTATION],
                        FavoriteMatch.IDHOMETEAM to hashMap[FavoriteMatch.IDHOMETEAM],
                        FavoriteMatch.IDAWAYTEAM to hashMap[FavoriteMatch.IDAWAYTEAM],
                        FavoriteMatch.STRRESULT to hashMap[FavoriteMatch.STRRESULT],
                        FavoriteMatch.STRCIRCUIT to hashMap[FavoriteMatch.STRCIRCUIT],
                        FavoriteMatch.STRCOUNTRY to hashMap[FavoriteMatch.STRCOUNTRY],
                        FavoriteMatch.STRCITY to hashMap[FavoriteMatch.STRCITY],
                        FavoriteMatch.STRPOSTER to hashMap[FavoriteMatch.STRPOSTER],
                        FavoriteMatch.STRFANART to hashMap[FavoriteMatch.STRFANART],
                        FavoriteMatch.STRTHUMB to hashMap[FavoriteMatch.STRTHUMB],
                        FavoriteMatch.STRBANNER to hashMap[FavoriteMatch.STRBANNER],
                        FavoriteMatch.STRMAP to hashMap[FavoriteMatch.STRMAP],
                        FavoriteMatch.STRLOCKED to hashMap[FavoriteMatch.STRLOCKED]
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
                delete(FavoriteMatch.TABLE_FAVORITE, "(IDEVENT = {id})",
                        "id" to id)
            }
            Snackbar.make(view, context.getString(R.string.msg_removeFromFavorite), Snackbar.LENGTH_LONG).show()
        } catch (e: SQLiteConstraintException) {
            Snackbar.make(view, e.localizedMessage, Snackbar.LENGTH_LONG).show()
        }
    }
}