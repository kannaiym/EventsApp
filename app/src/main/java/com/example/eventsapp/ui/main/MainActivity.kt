package com.example.eventsapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eventsapp.R
import com.example.eventsapp.databinding.ActivityMainBinding
import com.example.eventsapp.utils.setupWithNavController
import com.example.eventsapp.utils.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomView()
    }

    private fun setupBottomView() {
        val navView = findViewById<BottomNavigationView>(R.id.bottomNav)

        val navIds = listOf(
            R.navigation.profile,
            R.navigation.list,
            R.navigation.search
        )

        navView.setupWithNavController(
            navGraphIds = navIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navView,
            intent = intent
        )
    }
}
