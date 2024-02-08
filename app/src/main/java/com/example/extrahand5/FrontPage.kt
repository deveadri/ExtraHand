package com.example.extrahand5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FrontPage: AppCompatActivity() {
    private var carpinteroCard: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        carpinteroCard = findViewById(R.id.carpinteroCard)
        carpinteroCard?.setOnClickListener {
            val intent = Intent(this@FrontPage, CarpinteroActivity::class.java)
            startActivity(intent)
        }
    }
}
