package com.dev.fi.footballapps.ui.detailTeam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.data.Player
import com.dev.fi.footballapps.utils.invisible
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailTeamPlayerAdapter(private val context: Context, private val items: List<Player>, private val listener: (Player) -> Unit)
    : RecyclerView.Adapter<DetailTeamPlayerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_player, p0, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.bindItem(items[p1], listener)


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val placeHolder = view.findViewById<ProgressBar>(R.id.pb_placeholder)
        private val ivThumb = view.findViewById<ImageView>(R.id.iv_thumb)
        private val tvPlayerName = view.findViewById<TextView>(R.id.tv_playerName)
        private val tvPlayerPosition = view.findViewById<TextView>(R.id.tv_playerPosition)

        fun bindItem(items: Player, listener: (Player) -> Unit) {
            val logoUrl = items.strThumb

            if (logoUrl != null) Picasso.get().load(logoUrl).into(ivThumb, object : Callback {
                override fun onSuccess() {
                    placeHolder.invisible()
                }

                override fun onError(e: Exception?) {}
            })

            tvPlayerName.text = items.strPlayer
            tvPlayerPosition.text = items.strPosition
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}