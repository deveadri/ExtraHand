package com.example.extrahand5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FrontPage: AppCompatActivity() {
    private var carpinteroCard: CardView? = null
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_wishlist -> {
                    replaceFragment(WishlistFragment())
                    true
                }
                R.id.bottom_upload -> {
                    Toast.makeText(this, "Upload Image & Video", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.bottom_message -> {
                    replaceFragment(MessagesFragment())
                    true
                }
                R.id.bottom_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())

        carpinteroCard = findViewById(R.id.carpinteroCard)
        carpinteroCard?.setOnClickListener {
            val intent = Intent(this@FrontPage, CarpinteroActivity::class.java)
            startActivity(intent)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}