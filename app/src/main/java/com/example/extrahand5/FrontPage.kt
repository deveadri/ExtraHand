package com.example.extrahand5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.extrahand5.Jobs.CarpinteroActivity
import com.example.extrahand5.Jobs.CerrajeroActivity
import com.example.extrahand5.Jobs.ElectricistaActivity
import com.example.extrahand5.Jobs.FontaneroActivity
import com.example.extrahand5.Jobs.ObreroActivity
import com.example.extrahand5.Jobs.PintorActivity
import com.example.extrahand5.Navigator.HomeFragment
import com.example.extrahand5.Navigator.MessagesFragment
import com.example.extrahand5.Navigator.ProfileFragment
import com.example.extrahand5.Navigator.UploadFragment
import com.example.extrahand5.Navigator.WishlistFragment
import com.example.extrahand5.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class FrontPage: AppCompatActivity() {
    private var carpinteroCard: CardView? = null
    private var cerrajeroCard: CardView? = null
    private var electricistaCard: CardView? = null
    private var fontaneroCard: CardView? = null
    private var pintorCard: CardView? = null
    private var obreroCard: CardView? = null


    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    startActivity(Intent(this, FrontPage::class.java))
                    true
                }
                R.id.bottom_wishlist -> {
                    startActivity(Intent(this, WishlistFragment::class.java))
                    true
                }
                R.id.bottom_upload -> {
                    // Abre la actividad de carga de imágenes y vídeos
                    startActivity(Intent(this, UploadFragment::class.java))
                    true
                }
                R.id.bottom_message -> {
                    startActivity(Intent(this, MessagesFragment::class.java))
                    true
                }
                R.id.bottom_profile -> {
                    startActivity(Intent(this, ProfileFragment::class.java))
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())

        carpinteroCard = findViewById(R.id.carpinteroCard)
        carpinteroCard?.setOnClickListener {
            startActivity(Intent(this, CarpinteroActivity::class.java))
        }
        cerrajeroCard = findViewById(R.id.cerrajeroCard)
        cerrajeroCard?.setOnClickListener {
            startActivity(Intent(this, CerrajeroActivity::class.java))
        }
        electricistaCard = findViewById(R.id.electricistaCard)
        electricistaCard?.setOnClickListener {
            startActivity(Intent(this, ElectricistaActivity::class.java))
        }
        fontaneroCard = findViewById(R.id.fontaneroCard)
        fontaneroCard?.setOnClickListener {
            startActivity(Intent(this, FontaneroActivity::class.java))
        }
        pintorCard = findViewById(R.id.pintorCard)
        pintorCard?.setOnClickListener {
            startActivity(Intent(this, PintorActivity::class.java))
        }
        obreroCard = findViewById(R.id.obreroCard)
        obreroCard?.setOnClickListener {
            startActivity(Intent(this, ObreroActivity::class.java))
        }

    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}