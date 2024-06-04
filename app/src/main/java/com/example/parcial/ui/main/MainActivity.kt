package com.example.parcial.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.parcial.R
import com.example.parcial.databinding.ActivityMainBinding
import com.example.parcial.ui.explore.ExploreFragment
import com.example.parcial.ui.offers.OffersFragment
import com.example.parcial.ui.profile.ProfileFragment
import com.example.parcial.ui.search.SearchFragment
import com.example.parcial.ui.settings.SettingsFragment
import com.example.parcial.ui.splash.SplashFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var drawerToggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)


        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host, SplashFragment())
                .commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.explore -> {
                    replaceFragment(ExploreFragment())
                    true
                }

                R.id.search -> {
                    replaceFragment(SearchFragment())
                    true
                }

                R.id.offers -> {
                    replaceFragment(OffersFragment())
                    true
                }

                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }

                else -> false
            }

        }



        drawerLayout = binding.drawerLayout
        navigationView = binding.navView
        toolbar = binding.toolbar
        setSupportActionBar(toolbar)



        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profileFragment -> {
                    replaceFragment(ProfileFragment())

                    drawerLayout.closeDrawers()
                    true
                }

                R.id.settingsFragment -> {
                    replaceFragment(SettingsFragment())

                    drawerLayout.closeDrawers()
                    true
                }

                else -> false
            }
        }


        setupDrawerLayout()

    }

    private fun setupDrawerLayout() {
        drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.toolbar,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host, fragment)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        return NavigationUI.navigateUp(
            navHostFragment.navController,
            drawerLayout
        ) || super.onSupportNavigateUp()
    }


}


