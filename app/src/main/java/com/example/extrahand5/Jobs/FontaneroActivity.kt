package com.example.extrahand5.Jobs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.extrahand5.FrontPage
import com.example.extrahand5.Navigator.MessagesFragment
import com.example.extrahand5.Navigator.ProfileFragment
import com.example.extrahand5.Navigator.WishlistFragment
import com.example.extrahand5.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class FontaneroActivity : AppCompatActivity() {

    private val wishlistFragment = WishlistFragment()
    private val profileFragment = ProfileFragment()
    private val homeFragment = FrontPage()
    private val MessagesFragment = MessagesFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fontanero)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        loadFragment(wishlistFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom_wishlist -> {
                    loadFragment(wishlistFragment)
                    true
                }
                R.id.bottom_profile -> {
                    loadFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}


