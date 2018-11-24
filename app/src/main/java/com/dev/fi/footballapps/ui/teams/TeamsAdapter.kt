package com.dev.fi.footballapps.ui.teams

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.data.models.Team
import com.dev.fi.footballapps.utils.invisible
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class TeamsAdapter(private val context: Context, private val items: List<Team>, private val listener: (Team) -> Unit)
    : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_teams, p0, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.bindItem(items[p1], listener)


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val placeHolder = view.findViewById<ProgressBar>(R.id.pb_placeholder)
        private val ivLogo = view.findViewById<ImageView>(R.id.iv_logo)
        private val tvTeamName = view.findViewById<TextView>(R.id.tv_teamName)

        fun bindItem(items: Team, listener: (Team) -> Unit) {
            val logoUrl = items.strTeamBadge

            if (logoUrl != null) Picasso.get().load(logoUrl).into(ivLogo, object : Callback{
                override fun onSuccess() { placeHolder.invisible()}
                override fun onError(e: Exception?) {}
            })

            tvTeamName.text = items.strTeam
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}