package com.example.madlevel5task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.Database.Game
import kotlinx.android.synthetic.main.game_card_fragment.view.*
import java.text.SimpleDateFormat

class GameBacklogAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameBacklogAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(game: Game) {
            itemView.txtViewGameTitle.text = game.title
            itemView.txtViewPlatformTitle.text = game.platform

            val format = SimpleDateFormat("dd MMMM yyy")

            itemView.txtViewReleaseDate.text = "Release: " + format.format(game.release)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_card_fragment, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }
}