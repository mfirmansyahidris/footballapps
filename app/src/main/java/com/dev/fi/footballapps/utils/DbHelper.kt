package com.dev.fi.footballapps.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.data.Team
import org.jetbrains.anko.db.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FootballApps.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(Event.TABLE_EVENT, true,
                Event.IDEVENT to TEXT + UNIQUE,
                Event.IDSOCCERXML to TEXT,
                Event.STREVENT to TEXT,
                Event.STRFILENAME to TEXT,
                Event.STRSPORT to TEXT,
                Event.IDLEAGUE to TEXT,
                Event.STRLEAGUE to TEXT,
                Event.STRSEASON to TEXT,
                Event.STRDESCRIPTIONEN to TEXT,
                Event.STRHOMETEAM to TEXT,
                Event.STRAWAYTEAM to TEXT,
                Event.INTHOMESCORE to TEXT,
                Event.INTROUND to TEXT,
                Event.INTAWAYSCORE to TEXT,
                Event.INTSPECTATORS to TEXT,
                Event.STRHOMEGOALDETAILS to TEXT,
                Event.STRHOMEREDCARDS to TEXT,
                Event.STRHOMEYELLOWCARDS to TEXT,
                Event.STRHOMELINEUPGOALKEEPER to TEXT,
                Event.STRHOMELINEUPDEFENSE to TEXT,
                Event.STRHOMELINEUPMIDFIELD to TEXT,
                Event.STRHOMELINEUPFORWARD to TEXT,
                Event.STRHOMELINEUPSUBSTITUTES to TEXT,
                Event.STRHOMEFORMATION to TEXT,
                Event.STRAWAYREDCARDS to TEXT,
                Event.STRAWAYYELLOWCARDS to TEXT,
                Event.STRAWAYGOALDETAILS to TEXT,
                Event.STRAWAYLINEUPGOALKEEPER to TEXT,
                Event.STRAWAYLINEUPDEFENSE to TEXT,
                Event.STRAWAYLINEUPMIDFIELD to TEXT,
                Event.STRAWAYLINEUPFORWARD to TEXT,
                Event.STRAWAYLINEUPSUBSTITUTES to TEXT,
                Event.STRAWAYFORMATION to TEXT,
                Event.INTHOMESHOTS to TEXT,
                Event.INTAWAYSHOTS to TEXT,
                Event.DATEEVENT to TEXT,
                Event.STRDATE to TEXT,
                Event.STRTIME to TEXT,
                Event.STRTVSTATION to TEXT,
                Event.IDHOMETEAM to TEXT,
                Event.IDAWAYTEAM to TEXT,
                Event.STRRESULT to TEXT,
                Event.STRCIRCUIT to TEXT,
                Event.STRCOUNTRY to TEXT,
                Event.STRCITY to TEXT,
                Event.STRPOSTER to TEXT,
                Event.STRFANART to TEXT,
                Event.STRTHUMB to TEXT,
                Event.STRBANNER to TEXT,
                Event.STRMAP to TEXT,
                Event.STRLOCKED to TEXT
        )

        db.createTable(Team.TABLE_TEAMS, true,
                Team.IDTEAM to TEXT + UNIQUE,
                Team.IDSOCCERXML to TEXT,
                Team.INTLOVED to TEXT,
                Team.STRTEAM to TEXT,
                Team.STRTEAMSHORT to TEXT,
                Team.STRALTERNATE to TEXT,
                Team.INTFORMEDYEAR to TEXT,
                Team.STRSPORT to TEXT,
                Team.STRLEAGUE to TEXT,
                Team.IDLEAGUE to TEXT,
                Team.STRDIVISION to TEXT,
                Team.STRMANAGER to TEXT,
                Team.STRSTADIUM to TEXT,
                Team.STRKEYWORDS to TEXT,
                Team.STRRSS to TEXT,
                Team.STRSTADIUMTHUMB to TEXT,
                Team.STRSTADIUMDESCRIPTION to TEXT,
                Team.STRSTADIUMLOCATION to TEXT,
                Team.INTSTADIUMCAPACITY to TEXT,
                Team.STRWEBSITE to TEXT,
                Team.STRFACEBOOK to TEXT,
                Team.STRTWITTER to TEXT,
                Team.STRINSTAGRAM to TEXT,
                Team.STRDESCRIPTIONEN to TEXT,
                Team.STRDESCRIPTIONDE to TEXT,
                Team.STRDESCRIPTIONFR to TEXT,
                Team.STRDESCRIPTIONCN to TEXT,
                Team.STRDESCRIPTIONIT to TEXT,
                Team.STRDESCRIPTIONJP to TEXT,
                Team.STRDESCRIPTIONRU to TEXT,
                Team.STRDESCRIPTIONES to TEXT,
                Team.STRDESCRIPTIONPT to TEXT,
                Team.STRDESCRIPTIONSE to TEXT,
                Team.STRDESCRIPTIONNL to TEXT,
                Team.STRDESCRIPTIONHU to TEXT,
                Team.STRDESCRIPTIONNO to TEXT,
                Team.STRDESCRIPTIONIL to TEXT,
                Team.STRDESCRIPTIONPL to TEXT,
                Team.STRGENDER to TEXT,
                Team.STRCOUNTRY to TEXT,
                Team.STRTEAMBADGE to TEXT,
                Team.STRTEAMJERSEY to TEXT,
                Team.STRTEAMLOGO to TEXT,
                Team.STRTEAMFANART1 to TEXT,
                Team.STRTEAMFANART2 to TEXT,
                Team.STRTEAMFANART3 to TEXT,
                Team.STRTEAMFANART4 to TEXT,
                Team.STRTEAMBANNER to TEXT,
                Team.STRYOUTUBE to TEXT,
                Team.STRLOCKED to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(Event.TABLE_EVENT, true)
        db.dropTable(Team.TABLE_TEAMS, true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)