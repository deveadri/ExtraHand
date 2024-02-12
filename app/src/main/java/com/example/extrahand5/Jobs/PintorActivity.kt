package com.example.extrahand5.Jobs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.extrahand5.R

class PintorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pintor)

        // Encontrar vistas relevantes
        val anuncio1Layout = findViewById<LinearLayout>(R.id.anuncio1)
        val anuncio2Layout = findViewById<LinearLayout>(R.id.anuncio2)
        val anuncio3Layout = findViewById<LinearLayout>(R.id.anuncio3)
        val anuncio4Layout = findViewById<LinearLayout>(R.id.anuncio4)
        val anuncio5Layout = findViewById<LinearLayout>(R.id.anuncio5)
        val anuncio6Layout = findViewById<LinearLayout>(R.id.anuncio6)
        // Agregar OnClickListener para cada anuncio
    }

}

