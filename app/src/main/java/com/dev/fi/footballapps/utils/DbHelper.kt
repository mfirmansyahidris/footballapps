package com.dev.fi.footballapps.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.dev.fi.footballapps.data.tables.FavoriteMatch
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
        db.createTable(FavoriteMatch.TABLE_FAVORITE, true,
                FavoriteMatch.IDEVENT to TEXT + UNIQUE,
                FavoriteMatch.IDSOCCERXML to TEXT,
                FavoriteMatch.STREVENT to TEXT,
                FavoriteMatch.STRFILENAME to TEXT,
                FavoriteMatch.STRSPORT to TEXT,
                FavoriteMatch.IDLEAGUE to TEXT,
                FavoriteMatch.STRLEAGUE to TEXT,
                FavoriteMatch.STRSEASON to TEXT,
                FavoriteMatch.STRDESCRIPTIONEN to TEXT,
                FavoriteMatch.STRHOMETEAM to TEXT,
                FavoriteMatch.STRAWAYTEAM to TEXT,
                FavoriteMatch.INTHOMESCORE to TEXT,
                FavoriteMatch.INTROUND to TEXT,
                FavoriteMatch.INTAWAYSCORE to TEXT,
                FavoriteMatch.INTSPECTATORS to TEXT,
                FavoriteMatch.STRHOMEGOALDETAILS to TEXT,
                FavoriteMatch.STRHOMEREDCARDS to TEXT,
                FavoriteMatch.STRHOMEYELLOWCARDS to TEXT,
                FavoriteMatch.STRHOMELINEUPGOALKEEPER to TEXT,
                FavoriteMatch.STRHOMELINEUPDEFENSE to TEXT,
                FavoriteMatch.STRHOMELINEUPMIDFIELD to TEXT,
                FavoriteMatch.STRHOMELINEUPFORWARD to TEXT,
                FavoriteMatch.STRHOMELINEUPSUBSTITUTES to TEXT,
                FavoriteMatch.STRHOMEFORMATION to TEXT,
                FavoriteMatch.STRAWAYREDCARDS to TEXT,
                FavoriteMatch.STRAWAYYELLOWCARDS to TEXT,
                FavoriteMatch.STRAWAYGOALDETAILS to TEXT,
                FavoriteMatch.STRAWAYLINEUPGOALKEEPER to TEXT,
                FavoriteMatch.STRAWAYLINEUPDEFENSE to TEXT,
                FavoriteMatch.STRAWAYLINEUPMIDFIELD to TEXT,
                FavoriteMatch.STRAWAYLINEUPFORWARD to TEXT,
                FavoriteMatch.STRAWAYLINEUPSUBSTITUTES to TEXT,
                FavoriteMatch.STRAWAYFORMATION to TEXT,
                FavoriteMatch.INTHOMESHOTS to TEXT,
                FavoriteMatch.INTAWAYSHOTS to TEXT,
                FavoriteMatch.DATEEVENT to TEXT,
                FavoriteMatch.STRDATE to TEXT,
                FavoriteMatch.STRTIME to TEXT,
                FavoriteMatch.STRTVSTATION to TEXT,
                FavoriteMatch.IDHOMETEAM to TEXT,
                FavoriteMatch.IDAWAYTEAM to TEXT,
                FavoriteMatch.STRRESULT to TEXT,
                FavoriteMatch.STRCIRCUIT to TEXT,
                FavoriteMatch.STRCOUNTRY to TEXT,
                FavoriteMatch.STRCITY to TEXT,
                FavoriteMatch.STRPOSTER to TEXT,
                FavoriteMatch.STRFANART to TEXT,
                FavoriteMatch.STRTHUMB to TEXT,
                FavoriteMatch.STRBANNER to TEXT,
                FavoriteMatch.STRMAP to TEXT,
                FavoriteMatch.STRLOCKED to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(FavoriteMatch.TABLE_FAVORITE, true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)