package com.example.parcial.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.parcial.R
import com.example.parcial.ui.explore.ExploreFragment
import com.example.parcial.ui.offers.OffersFragment
import com.example.parcial.ui.profile.ProfileFragment
import com.example.parcial.ui.search.SearchFragment
import com.example.parcial.ui.splash.SplashFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNaviationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SplashFragment())
                .commit()
        }

        bottomNaviationView = findViewById(R.id.bottomNavigationView)

    bottomNaviationView.setOnItemSelectedListener { menuItem ->
        when(menuItem.itemId){
            R.id.explore ->{
                replaceFragment(ExploreFragment())
                true
            }
            R.id.search ->{
                replaceFragment(SearchFragment())
                true
            }
            R.id.offers ->{
                replaceFragment(OffersFragment())
                true
            }
            R.id.profile ->{
                replaceFragment(ProfileFragment())
                true
            }
            else -> false
        }

    }
    //replaceFragment(ExploreFragment())

}
private fun replaceFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
}

}
