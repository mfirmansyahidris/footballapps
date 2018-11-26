package com.dev.fi.footballapps.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

@Parcelize
data class Event(
        @SerializedName("idEvent")
        var idEvent: String? = "",

        @SerializedName("idSoccerXML")
        var idSoccerXML: String? = "",

        @SerializedName("strEvent")
        var strEvent: String? = "",

        @SerializedName("strFilename")
        var strFilename: String? = "",

        @SerializedName("strSport")
        var strSport: String? = "",

        @SerializedName("idLeague")
        var idLeague: String? = "",

        @SerializedName("strLeague")
        var strLeague: String? = "",

        @SerializedName("strSeason")
        var strSeason: String? = "",

        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String? = "",

        @SerializedName("strHomeTeam")
        var strHomeTeam: String? = "",

        @SerializedName("strAwayTeam")
        var strAwayTeam: String? = "",

        @SerializedName("intHomeScore")
        var intHomeScore: String? = "",

        @SerializedName("intRound")
        var intRound: String? = "",

        @SerializedName("intAwayScore")
        var intAwayScore: String? = "",

        @SerializedName("intSpectators")
        var intSpectators: String? = "",

        @SerializedName("strHomeGoalDetails")
        var strHomeGoalDetails: String? = "",

        @SerializedName("strHomeRedCards")
        var strHomeRedCards: String? = "",

        @SerializedName("strHomeYellowCards")
        var strHomeYellowCards: String? = "",

        @SerializedName("strHomeLineupGoalkeeper")
        var strHomeLineupGoalkeeper: String? = "",

        @SerializedName("strHomeLineupDefense")
        var strHomeLineupDefense: String? = "",

        @SerializedName("strHomeLineupMidfield")
        var strHomeLineupMidfield: String? = "",

        @SerializedName("strHomeLineupForward")
        var strHomeLineupForward: String? = "",

        @SerializedName("strHomeLineupSubstitutes")
        var strHomeLineupSubstitutes: String? = "",

        @SerializedName("strHomeFormation")
        var strHomeFormation: String? = "",

        @SerializedName("strAwayRedCards")
        var strAwayRedCards: String? = "",

        @SerializedName("strAwayYellowCards")
        var strAwayYellowCards: String? = "",

        @SerializedName("strAwayGoalDetails")
        var strAwayGoalDetails: String? = "",

        @SerializedName("strAwayLineupGoalkeeper")
        var strAwayLineupGoalkeeper: String? = "",

        @SerializedName("strAwayLineupDefense")
        var strAwayLineupDefense: String? = "",

        @SerializedName("strAwayLineupMidfield")
        var strAwayLineupMidfield: String? = "",

        @SerializedName("strAwayLineupForward")
        var strAwayLineupForward: String? = "",

        @SerializedName("strAwayLineupSubstitutes")
        var strAwayLineupSubstitutes: String? = "",

        @SerializedName("strAwayFormation")
        var strAwayFormation: String? = "",

        @SerializedName("intHomeShots")
        var intHomeShots: String? = "",

        @SerializedName("intAwayShots")
        var intAwayShots: String? = "",

        @SerializedName("dateEvent")
        var dateEvent: String? = "",

        @SerializedName("strDate")
        var strDate: String? = "",

        @SerializedName("strTime")
        var strTime: String? = "",

        @SerializedName("strTVStation")
        var strTVStation: String? = "",

        @SerializedName("idHomeTeam")
        var idHomeTeam: String? = "",

        @SerializedName("idAwayTeam")
        var idAwayTeam: String? = "",

        @SerializedName("strResult")
        var strResult: String? = "",

        @SerializedName("strCircuit")
        var strCircuit: String? = "",

        @SerializedName("strCountry")
        var strCountry: String? = "",

        @SerializedName("strCity")
        var strCity: String? = "",

        @SerializedName("strPoster")
        var strPoster: String? = "",

        @SerializedName("strFanart")
        var strFanart: String? = "",

        @SerializedName("strThumb")
        var strThumb: String? = "",

        @SerializedName("strBanner")
        var strBanner: String? = "",

        @SerializedName("strMap")
        var strMap: String? = "",

        @SerializedName("strLocked")
        var strLocked: String? = ""
) : Parcelable {
        companion object {
                const val TABLE_EVENT: String = "TABLE_EVENT"
                const val IDEVENT: String = "IDEVENT"
                const val IDSOCCERXML: String = "IDSOCCERXML"
                const val STREVENT: String = "STREVENT"
                const val STRFILENAME: String = "STRFILENAME"
                const val STRSPORT: String = "STRSPORT"
                const val IDLEAGUE: String = "IDLEAGUE"
                const val STRLEAGUE: String = "STRLEAGUE"
                const val STRSEASON: String = "STRSEASON"
                const val STRDESCRIPTIONEN: String = "STRDESCRIPTIONEN"
                const val STRHOMETEAM: String = "STRHOMETEAM"
                const val STRAWAYTEAM: String = "STRAWAYTEAM"
                const val INTHOMESCORE: String = "INTHOMESCORE"
                const val INTROUND: String = "INTROUND"
                const val INTAWAYSCORE: String = "INTAWAYSCORE"
                const val INTSPECTATORS: String = "INTSPECTATORS"
                const val STRHOMEGOALDETAILS: String = "STRHOMEGOALDETAILS"
                const val STRHOMEREDCARDS: String = "STRHOMEREDCARDS"
                const val STRHOMEYELLOWCARDS: String = "STRHOMEYELLOWCARDS"
                const val STRHOMELINEUPGOALKEEPER: String = "STRHOMELINEUPGOALKEEPER"
                const val STRHOMELINEUPDEFENSE: String = "STRHOMELINEUPDEFENSE"
                const val STRHOMELINEUPMIDFIELD: String = "STRHOMELINEUPMIDFIELD"
                const val STRHOMELINEUPFORWARD: String = "STRHOMELINEUPFORWARD"
                const val STRHOMELINEUPSUBSTITUTES: String = "STRHOMELINEUPSUBSTITUTES"
                const val STRHOMEFORMATION: String = "STRHOMEFORMATION"
                const val STRAWAYREDCARDS: String = "STRAWAYREDCARDS"
                const val STRAWAYYELLOWCARDS: String = "STRAWAYYELLOWCARDS"
                const val STRAWAYGOALDETAILS: String = "STRAWAYGOALDETAILS"
                const val STRAWAYLINEUPGOALKEEPER: String = "STRAWAYLINEUPGOALKEEPER"
                const val STRAWAYLINEUPDEFENSE: String = "STRAWAYLINEUPDEFENSE"
                const val STRAWAYLINEUPMIDFIELD: String = "STRAWAYLINEUPMIDFIELD"
                const val STRAWAYLINEUPFORWARD: String = "STRAWAYLINEUPFORWARD"
                const val STRAWAYLINEUPSUBSTITUTES: String = "STRAWAYLINEUPSUBSTITUTES"
                const val STRAWAYFORMATION: String = "STRAWAYFORMATION"
                const val INTHOMESHOTS: String = "INTHOMESHOTS"
                const val INTAWAYSHOTS: String = "INTAWAYSHOTS"
                const val DATEEVENT: String = "DATEEVENT"
                const val STRDATE: String = "STRDATE"
                const val STRTIME: String = "STRTIME"
                const val STRTVSTATION: String = "STRTVSTATION"
                const val IDHOMETEAM: String = "IDHOMETEAM"
                const val IDAWAYTEAM: String = "IDAWAYTEAM"
                const val STRRESULT: String = "STRRESULT"
                const val STRCIRCUIT: String = "STRCIRCUIT"
                const val STRCOUNTRY: String = "STRCOUNTRY"
                const val STRCITY: String = "STRCITY"
                const val STRPOSTER: String = "STRPOSTER"
                const val STRFANART: String = "STRFANART"
                const val STRTHUMB: String = "STRTHUMB"
                const val STRBANNER: String = "STRBANNER"
                const val STRMAP: String = "STRMAP"
                const val STRLOCKED: String = "STRLOCKED"
        }
}