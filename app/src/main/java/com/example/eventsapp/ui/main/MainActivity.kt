package com.example.eventsapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventsapp.R
import com.example.eventsapp.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
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

//import android.os.Bundle
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        setupBottomNav()
//        setupViewPager()
//
//    }
//
//    private fun setupViewPager() {
//        adapter = MainViewPagerAdapter(this)
//        adapter.addFragments(PublicationFragment())
//        adapter.addFragments(ProfileFragment())
//        adapter.addFragments(SearchFragment())
//        //adapter.addFragments(ResumeFragment())
//        view_pager.adapter = adapter
//        view_pager.offscreenPageLimit = 4
//        view_pager.isEnabled = false
//        view_pager.isUserInputEnabled = false
//    }
//
//    private fun setupBottomNavigationView() {
//        bottom_navigation.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.bottom_home -> changeCurrentFragment(0)
//                R.id.bottom_info -> changeCurrentFragment(1)
//                R.id.bottom_search -> changeCurrentFragment(2)
//                R.id.bottom_resume -> changeCurrentFragment(3)
//            }
//            true
//        }
//    }
//
//    private fun changeCurrentFragment(position: Int) {
//        view_pager.setCurrentItem(position, false)
//    }
//}
//}