package com.dev.fi.footballapps.utils.dbObject

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.view.View
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.data.Event
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

object DataEvent {
    fun getDatas(context: Context): List<Event> {
        var items: List<Event> = mutableListOf()
        context.database.use {
            val result = select(Event.TABLE_EVENT)
            items = result.parseList(classParser())
        }
        return items
    }

    fun getDataById(context: Context, byId: String): List<Event> {
        var items: List<Event> = mutableListOf()
        context.database.use {
            val result = select(Event.TABLE_EVENT).whereArgs("${Event.IDEVENT} = '$byId'")
            items = result.parseList(classParser())
        }
        return items
    }


    fun insert(context: Context, view: View, hashMap: LinkedHashMap<String, String?>) {
        try {
            context.database.use {
                insert(Event.TABLE_EVENT,
                        Event.IDEVENT to hashMap[Event.IDEVENT],
                        Event.IDSOCCERXML to hashMap[Event.IDSOCCERXML],
                        Event.STREVENT to hashMap[Event.STREVENT],
                        Event.STRFILENAME to hashMap[Event.STRFILENAME],
                        Event.STRSPORT to hashMap[Event.STRSPORT],
                        Event.IDLEAGUE to hashMap[Event.IDLEAGUE],
                        Event.STRLEAGUE to hashMap[Event.STRLEAGUE],
                        Event.STRSEASON to hashMap[Event.STRSEASON],
                        Event.STRDESCRIPTIONEN to hashMap[Event.STRDESCRIPTIONEN],
                        Event.STRHOMETEAM to hashMap[Event.STRHOMETEAM],
                        Event.STRAWAYTEAM to hashMap[Event.STRAWAYTEAM],
                        Event.INTHOMESCORE to hashMap[Event.INTHOMESCORE],
                        Event.INTROUND to hashMap[Event.INTROUND],
                        Event.INTAWAYSCORE to hashMap[Event.INTAWAYSCORE],
                        Event.INTSPECTATORS to hashMap[Event.INTSPECTATORS],
                        Event.STRHOMEGOALDETAILS to hashMap[Event.STRHOMEGOALDETAILS],
                        Event.STRHOMEREDCARDS to hashMap[Event.STRHOMEREDCARDS],
                        Event.STRHOMEYELLOWCARDS to hashMap[Event.STRHOMEYELLOWCARDS],
                        Event.STRHOMELINEUPGOALKEEPER to hashMap[Event.STRHOMELINEUPGOALKEEPER],
                        Event.STRHOMELINEUPDEFENSE to hashMap[Event.STRHOMELINEUPDEFENSE],
                        Event.STRHOMELINEUPMIDFIELD to hashMap[Event.STRHOMELINEUPMIDFIELD],
                        Event.STRHOMELINEUPFORWARD to hashMap[Event.STRHOMELINEUPFORWARD],
                        Event.STRHOMELINEUPSUBSTITUTES to hashMap[Event.STRHOMELINEUPSUBSTITUTES],
                        Event.STRHOMEFORMATION to hashMap[Event.STRHOMEFORMATION],
                        Event.STRAWAYREDCARDS to hashMap[Event.STRAWAYREDCARDS],
                        Event.STRAWAYYELLOWCARDS to hashMap[Event.STRAWAYYELLOWCARDS],
                        Event.STRAWAYGOALDETAILS to hashMap[Event.STRAWAYGOALDETAILS],
                        Event.STRAWAYLINEUPGOALKEEPER to hashMap[Event.STRAWAYLINEUPGOALKEEPER],
                        Event.STRAWAYLINEUPDEFENSE to hashMap[Event.STRAWAYLINEUPDEFENSE],
                        Event.STRAWAYLINEUPMIDFIELD to hashMap[Event.STRAWAYLINEUPMIDFIELD],
                        Event.STRAWAYLINEUPFORWARD to hashMap[Event.STRAWAYLINEUPFORWARD],
                        Event.STRAWAYLINEUPSUBSTITUTES to hashMap[Event.STRAWAYLINEUPSUBSTITUTES],
                        Event.STRAWAYFORMATION to hashMap[Event.STRAWAYFORMATION],
                        Event.INTHOMESHOTS to hashMap[Event.INTHOMESHOTS],
                        Event.INTAWAYSHOTS to hashMap[Event.INTAWAYSHOTS],
                        Event.DATEEVENT to hashMap[Event.DATEEVENT],
                        Event.STRDATE to hashMap[Event.STRDATE],
                        Event.STRTIME to hashMap[Event.STRTIME],
                        Event.STRTVSTATION to hashMap[Event.STRTVSTATION],
                        Event.IDHOMETEAM to hashMap[Event.IDHOMETEAM],
                        Event.IDAWAYTEAM to hashMap[Event.IDAWAYTEAM],
                        Event.STRRESULT to hashMap[Event.STRRESULT],
                        Event.STRCIRCUIT to hashMap[Event.STRCIRCUIT],
                        Event.STRCOUNTRY to hashMap[Event.STRCOUNTRY],
                        Event.STRCITY to hashMap[Event.STRCITY],
                        Event.STRPOSTER to hashMap[Event.STRPOSTER],
                        Event.STRFANART to hashMap[Event.STRFANART],
                        Event.STRTHUMB to hashMap[Event.STRTHUMB],
                        Event.STRBANNER to hashMap[Event.STRBANNER],
                        Event.STRMAP to hashMap[Event.STRMAP],
                        Event.STRLOCKED to hashMap[Event.STRLOCKED]
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
                delete(Event.TABLE_EVENT, "(IDEVENT = {id})",
                        "id" to id)
            }
            Snackbar.make(view, context.getString(R.string.msg_removeFromFavorite), Snackbar.LENGTH_LONG).show()
        } catch (e: SQLiteConstraintException) {
            Snackbar.make(view, e.localizedMessage, Snackbar.LENGTH_LONG).show()
        }
    }
}