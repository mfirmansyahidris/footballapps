package com.dev.fi.footballapps.ui.detailTeam

import android.view.MenuItem
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.base.BaseActivity
import com.dev.fi.footballapps.data.Player
import com.dev.fi.footballapps.utils.invisible
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_player.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailPlayerActivity: BaseActivity(){
    override fun getLayoutResource(): Int = R.layout.activity_detail_player

    override fun getToolbarResource(): Int = R.id.main_toolbar

    override fun getToolbarTitle(): String = getString(R.string.app_name)

    override fun mainCode() {
        val player = intent.getParcelableExtra<Player>("player")

        toolbar = findViewById(R.id.main_toolbar)
        toolbar?.title = player.strPlayer

        val bannerUrl = player.strFanart1

        if (bannerUrl != null) Picasso.get().load(bannerUrl).into(iv_banner, object : Callback {
            override fun onSuccess() { pb_placeholder.invisible()}
            override fun onError(e: Exception?) {}
        })

        tv_height.text = getSimpleValue(player.strHeight)
        tv_wight.text = getSimpleValue(player.strWeight)
        tv_position.text = player.strPosition
        tv_descr.text = player.strDescriptionEN

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun getSimpleValue(text: String?): String {
        return if((text == null) || (text.toUpperCase() == "NULL") || (text == "")){
            "0.0"
        }
        else{
            val re = Regex("[^1-9.]")
            re.replace(text.toString(), "")
        }
    }
}