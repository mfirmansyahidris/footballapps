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
data class Team(
        @SerializedName("idTeam")
        var idTeam: String? = "",

        @SerializedName("idSoccerXML")
        var idSoccerXML: String? = "",

        @SerializedName("intLoved")
        var intLoved: String? = "",

        @SerializedName("strTeam")
        var strTeam: String? = "",

        @SerializedName("strTeamShort")
        var strTeamShort: String? = "",

        @SerializedName("strAlternate")
        var strAlternate: String? = "",

        @SerializedName("intFormedYear")
        var intFormedYear: String? = "",

        @SerializedName("strSport")
        var strSport: String? = "",

        @SerializedName("strLeague")
        var strLeague: String? = "",

        @SerializedName("idLeague")
        var idLeague: String? = "",

        @SerializedName("strDivision")
        var strDivision: String? = "",

        @SerializedName("strManager")
        var strManager: String? = "",

        @SerializedName("strStadium")
        var strStadium: String? = "",

        @SerializedName("strKeywords")
        var strKeywords: String? = "",

        @SerializedName("strRSS")
        var strRSS: String? = "",

        @SerializedName("strStadiumThumb")
        var strStadiumThumb: String? = "",

        @SerializedName("strStadiumDescription")
        var strStadiumDescription: String? = "",

        @SerializedName("strStadiumLocation")
        var strStadiumLocation: String? = "",

        @SerializedName("intStadiumCapacity")
        var intStadiumCapacity: String? = "",

        @SerializedName("strWebsite")
        var strWebsite: String? = "",

        @SerializedName("strFacebook")
        var strFacebook: String? = "",

        @SerializedName("strTwitter")
        var strTwitter: String? = "",

        @SerializedName("strInstagram")
        var strInstagram: String? = "",

        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String? = "",

        @SerializedName("strDescriptionDE")
        var strDescriptionDE: String? = "",

        @SerializedName("strDescriptionFR")
        var strDescriptionFR: String? = "",

        @SerializedName("strDescriptionCN")
        var strDescriptionCN: String? = "",

        @SerializedName("strDescriptionIT")
        var strDescriptionIT: String? = "",

        @SerializedName("strDescriptionJP")
        var strDescriptionJP: String? = "",

        @SerializedName("strDescriptionRU")
        var strDescriptionRU: String? = "",

        @SerializedName("strDescriptionES")
        var strDescriptionES: String? = "",

        @SerializedName("strDescriptionPT")
        var strDescriptionPT: String? = "",

        @SerializedName("strDescriptionSE")
        var strDescriptionSE: String? = "",

        @SerializedName("strDescriptionNL")
        var strDescriptionNL: String? = "",

        @SerializedName("strDescriptionHU")
        var strDescriptionHU: String? = "",

        @SerializedName("strDescriptionNO")
        var strDescriptionNO: String? = "",

        @SerializedName("strDescriptionIL")
        var strDescriptionIL: String? = "",

        @SerializedName("strDescriptionPL")
        var strDescriptionPL: String? = "",

        @SerializedName("strGender")
        var strGender: String? = "",

        @SerializedName("strCountry")
        var strCountry: String? = "",

        @SerializedName("strTeamBadge")
        var strTeamBadge: String? = "",

        @SerializedName("strTeamJersey")
        var strTeamJersey: String? = "",

        @SerializedName("strTeamLogo")
        var strTeamLogo: String? = "",

        @SerializedName("strTeamFanart1")
        var strTeamFanart1: String? = "",

        @SerializedName("strTeamFanart2")
        var strTeamFanart2: String? = "",

        @SerializedName("strTeamFanart3")
        var strTeamFanart3: String? = "",

        @SerializedName("strTeamFanart4")
        var strTeamFanart4: String? = "",

        @SerializedName("strTeamBanner")
        var strTeamBanner: String? = "",

        @SerializedName("strYoutube")
        var strYoutube: String? = "",

        @SerializedName("strLocked")
        var strLocked: String? = ""

) : Parcelable{
        companion object {
                const val TABLE_TEAMS: String = "TABLE_TEAMS"
                const val IDTEAM: String = "IDTEAM"
                const val IDSOCCERXML: String = "IDSOCCERXML"
                const val INTLOVED: String = "INTLOVED"
                const val STRTEAM: String = "STRTEAM"
                const val STRTEAMSHORT: String = "STRTEAMSHORT"
                const val STRALTERNATE: String = "STRALTERNATE"
                const val INTFORMEDYEAR: String = "INTFORMEDYEAR"
                const val STRSPORT: String = "STRSPORT"
                const val STRLEAGUE: String = "STRLEAGUE"
                const val IDLEAGUE: String = "IDLEAGUE"
                const val STRDIVISION: String = "STRDIVISION"
                const val STRMANAGER: String = "STRMANAGER"
                const val STRSTADIUM: String = "STRSTADIUM"
                const val STRKEYWORDS: String = "STRKEYWORDS"
                const val STRRSS: String = "STRRSS"
                const val STRSTADIUMTHUMB: String = "STRSTADIUMTHUMB"
                const val STRSTADIUMDESCRIPTION: String = "STRSTADIUMDESCRIPTION"
                const val STRSTADIUMLOCATION: String = "STRSTADIUMLOCATION"
                const val INTSTADIUMCAPACITY: String = "INTSTADIUMCAPACITY"
                const val STRWEBSITE: String = "STRWEBSITE"
                const val STRFACEBOOK: String = "STRFACEBOOK"
                const val STRTWITTER: String = "STRTWITTER"
                const val STRINSTAGRAM: String = "STRINSTAGRAM"
                const val STRDESCRIPTIONEN: String = "STRDESCRIPTIONEN"
                const val STRDESCRIPTIONDE: String = "STRDESCRIPTIONDE"
                const val STRDESCRIPTIONFR: String = "STRDESCRIPTIONFR"
                const val STRDESCRIPTIONCN: String = "STRDESCRIPTIONCN"
                const val STRDESCRIPTIONIT: String = "STRDESCRIPTIONIT"
                const val STRDESCRIPTIONJP: String = "STRDESCRIPTIONJP"
                const val STRDESCRIPTIONRU: String = "STRDESCRIPTIONRU"
                const val STRDESCRIPTIONES: String = "STRDESCRIPTIONES"
                const val STRDESCRIPTIONPT: String = "STRDESCRIPTIONPT"
                const val STRDESCRIPTIONSE: String = "STRDESCRIPTIONSE"
                const val STRDESCRIPTIONNL: String = "STRDESCRIPTIONNL"
                const val STRDESCRIPTIONHU: String = "STRDESCRIPTIONHU"
                const val STRDESCRIPTIONNO: String = "STRDESCRIPTIONNO"
                const val STRDESCRIPTIONIL: String = "STRDESCRIPTIONIL"
                const val STRDESCRIPTIONPL: String = "STRDESCRIPTIONPL"
                const val STRGENDER: String = "STRGENDER"
                const val STRCOUNTRY: String = "STRCOUNTRY"
                const val STRTEAMBADGE: String = "STRTEAMBADGE"
                const val STRTEAMJERSEY: String = "STRTEAMJERSEY"
                const val STRTEAMLOGO: String = "STRTEAMLOGO"
                const val STRTEAMFANART1: String = "STRTEAMFANART1"
                const val STRTEAMFANART2: String = "STRTEAMFANART2"
                const val STRTEAMFANART3: String = "STRTEAMFANART3"
                const val STRTEAMFANART4: String = "STRTEAMFANART4"
                const val STRTEAMBANNER: String = "STRTEAMBANNER"
                const val STRYOUTUBE: String = "STRYOUTUBE"
                const val STRLOCKED: String = "STRLOCKED"
        }
}