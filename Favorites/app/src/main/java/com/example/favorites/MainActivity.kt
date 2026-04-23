package com.example.favorites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val artistList = listOf(
            Artist("Artist 1", R.drawable.person1),
            Artist("Artist 2", R.drawable.person2),
            Artist("Artist 3", R.drawable.person3),
            Artist("Artist 4", R.drawable.person4),
            Artist("Artist 5", R.drawable.person5),
            Artist("Artist 6", R.drawable.person6),
            Artist("Artist 7", R.drawable.person7),
            Artist("Artist 8", R.drawable.person8),
            Artist("Artist 9", R.drawable.person9)
        )

        val adapter = ArtistAdapter(artistList) { artist ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", artist.name)
            intent.putExtra("image", artist.imageResId)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}

data class Artist(
    val name: String,
    val imageResId: Int
)