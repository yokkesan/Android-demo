package com.example.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArtistAdapter(
    private val artistList: List<Artist>,
    private val onItemClick: (Artist) -> Unit
) : RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageArtist)
        val name: TextView = view.findViewById(R.id.textName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artist, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = artistList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist = artistList[position]

        holder.name.text = artist.name
        holder.image.setImageResource(artist.imageResId)

        holder.itemView.setOnClickListener {
            onItemClick(artist)
        }
    }
}