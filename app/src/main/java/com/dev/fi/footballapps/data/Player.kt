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
data class Player(
        @SerializedName("idPlayer")
        val idPlayer: String? = "",

        @SerializedName("idTeam")
        val idTeam: String? = "",

        @SerializedName("idSoccerXML")
        val idSoccerXML: String? = "",

        @SerializedName("idPlayerManager")
        val idPlayerManager: String? = "",

        @SerializedName("strNationality")
        val strNationality: String? = "",

        @SerializedName("strPlayer")
        val strPlayer: String? = "",

        @SerializedName("strTeam")
        val strTeam: String? = "",

        @SerializedName("strSport")
        val strSport: String? = "",

        @SerializedName("intSoccerXMLTeamID")
        val intSoccerXMLTeamID: String? = "",

        @SerializedName("dateBorn")
        val dateBorn: String? = "",

        @SerializedName("dateSigned")
        val dateSigned: String? = "",

        @SerializedName("strSigning")
        val strSigning: String? = "",

        @SerializedName("strWage")
        val strWage: String? = "",

        @SerializedName("strBirthLocation")
        val strBirthLocation: String? = "",

        @SerializedName("strDescriptionEN")
        val strDescriptionEN: String? = "",

        @SerializedName("strDescriptionDE")
        val strDescriptionDE: String? = "",

        @SerializedName("strDescriptionFR")
        val strDescriptionFR: String? = "",

        @SerializedName("strDescriptionCN")
        val strDescriptionCN: String? = "",

        @SerializedName("strDescriptionIT")
        val strDescriptionIT: String? = "",

        @SerializedName("strDescriptionJP")
        val strDescriptionJP: String? = "",

        @SerializedName("strDescriptionRU")
        val strDescriptionRU: String? = "",

        @SerializedName("strDescriptionES")
        val strDescriptionES: String? = "",

        @SerializedName("strDescriptionPT")
        val strDescriptionPT: String? = "",

        @SerializedName("strDescriptionSE")
        val strDescriptionSE: String? = "",

        @SerializedName("strDescriptionNL")
        val strDescriptionNL: String? = "",

        @SerializedName("strDescriptionHU")
        val strDescriptionHU: String? = "",

        @SerializedName("strDescriptionNO")
        val strDescriptionNO: String? = "",

        @SerializedName("strDescriptionIL")
        val strDescriptionIL: String? = "",

        @SerializedName("strDescriptionPL")
        val strDescriptionPL: String? = "",

        @SerializedName("strGender")
        val strGender: String? = "",

        @SerializedName("strPosition")
        val strPosition: String? = "",

        @SerializedName("strCollege")
        val strCollege: String? = "",

        @SerializedName("strFacebook")
        val strFacebook: String? = "",

        @SerializedName("strWebsite")
        val strWebsite: String? = "",

        @SerializedName("strTwitter")
        val strTwitter: String? = "",

        @SerializedName("strInstagram")
        val strInstagram: String? = "",

        @SerializedName("strYoutube")
        val strYoutube: String? = "",

        @SerializedName("strHeight")
        val strHeight: String? = "",

        @SerializedName("strWeight")
        val strWeight: String? = "",

        @SerializedName("intLoved")
        val intLoved: String? = "",

        @SerializedName("strThumb")
        val strThumb: String? = "",

        @SerializedName("strCutout")
        val strCutout: String? = "",

        @SerializedName("strBanner")
        val strBanner: String? = "",

        @SerializedName("strFanart1")
        val strFanart1: String? = "",

        @SerializedName("strFanart2")
        val strFanart2: String? = "",

        @SerializedName("strFanart3")
        val strFanart3: String? = "",

        @SerializedName("strFanart4")
        val strFanart4: String? = "",

        @SerializedName("strLocked")
        val strLocked: String? = ""
) : Parcelable