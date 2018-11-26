package com.dev.fi.footballapps.ui.match

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.fi.footballapps.R
import com.dev.fi.footballapps.data.Event
import com.dev.fi.footballapps.utils.reformatDate
import com.dev.fi.footballapps.utils.setToLocalTime

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class MatchAdapter(private val context: Context, private val items: List<Event>, private val listener: (Event) -> Unit)
    : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, p0, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.bindItem(items[p1], listener)


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvDateEvent = view.findViewById<TextView>(R.id.tv_dateEvent)
        private val tvTimeEvent = view.findViewById<TextView>(R.id.tv_timeEvent)
        private val tvTeamHome = view.findViewById<TextView>(R.id.tv_teamHome)
        private val tvTeamHomeScore = view.findViewById<TextView>(R.id.tv_teamHomeScore)
        private val tvTeamAwayScore = view.findViewById<TextView>(R.id.tv_teamAwayScore)
        private val tvTeamAway = view.findViewById<TextView>(R.id.tv_teamAway)

        fun bindItem(items: Event, listener: (Event) -> Unit) {
            tvDateEvent.text = reformatDate(items.dateEvent)
            tvTimeEvent.text = setToLocalTime(items.strTime)
            tvTeamHome.text = items.strHomeTeam
            tvTeamHomeScore.text = items.intHomeScore
            tvTeamAwayScore.text = items.intAwayScore
            tvTeamAway.text = items.strAwayTeam

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}