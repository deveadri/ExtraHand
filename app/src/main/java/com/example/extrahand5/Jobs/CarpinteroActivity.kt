package com.example.extrahand5.Jobs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.extrahand5.R

class CarpinteroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpintero)

        // Encontrar vistas relevantes
        val anuncio1HeartButton = findViewById<ImageView>(R.id.heart_button1)
        val anuncio2HeartButton = findViewById<ImageView>(R.id.heart_button2)
        val anuncio3HeartButton = findViewById<ImageView>(R.id.heart_button3)
        val anuncio4HeartButton = findViewById<ImageView>(R.id.heart_button4)


        // Agregar funcionalidad a los botones de corazón
        anuncio1HeartButton.setOnClickListener {
            addToWishlist("Anuncio 1")
        }
        anuncio2HeartButton.setOnClickListener {
            addToWishlist("Anuncio 2")
        }
        anuncio3HeartButton.setOnClickListener {
            addToWishlist("Anuncio 3")
        }
        anuncio4HeartButton.setOnClickListener {
            addToWishlist("Anuncio 4")
        }
    }

    // Método para agregar a la lista de deseos
    private fun addToWishlist(anuncio: String) {
        // Aquí puedes agregar lógica para añadir el anuncio a la lista de deseos
        Toast.makeText(this, "Añadido a la lista de deseos: $anuncio", Toast.LENGTH_SHORT).show()
    }
}

