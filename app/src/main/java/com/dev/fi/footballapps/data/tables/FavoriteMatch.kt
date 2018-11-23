package com.dev.fi.footballapps.data.tables

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

data class FavoriteMatch(
        var idEvent: String?,
        var idSoccerXML: String?,
        var strEvent: String?,
        var strFilename: String?,
        var strSport: String?,
        var idLeague: String?,
        var strLeague: String?,
        var strSeason: String?,
        var strDescriptionEN: String?,
        var strHomeTeam: String?,
        var strAwayTeam: String?,
        var intHomeScore: String?,
        var intRound: String?,
        var intAwayScore: String?,
        var intSpectators: String?,
        var strHomeGoalDetails: String?,
        var strHomeRedCards: String?,
        var strHomeYellowCards: String?,
        var strHomeLineupGoalkeeper: String?,
        var strHomeLineupDefense: String?,
        var strHomeLineupMidfield: String?,
        var strHomeLineupForward: String?,
        var strHomeLineupSubstitutes: String?,
        var strHomeFormation: String?,
        var strAwayRedCards: String?,
        var strAwayYellowCards: String?,
        var strAwayGoalDetails: String?,
        var strAwayLineupGoalkeeper: String?,
        var strAwayLineupDefense: String?,
        var strAwayLineupMidfield: String?,
        var strAwayLineupForward: String?,
        var strAwayLineupSubstitutes: String?,
        var strAwayFormation: String?,
        var intHomeShots: String?,
        var intAwayShots: String?,
        var dateEvent: String?,
        var strDate: String?,
        var strTime: String?,
        var strTVStation: String?,
        var idHomeTeam: String?,
        var idAwayTeam: String?,
        var strResult: String?,
        var strCircuit: String?,
        var strCountry: String?,
        var strCity: String?,
        var strPoster: String?,
        var strFanart: String?,
        var strThumb: String?,
        var strBanner: String?,
        var strMap: String?,
        var strLocked: String?
) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
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