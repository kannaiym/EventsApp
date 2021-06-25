package com.example.eventsapp.authorization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.eventsapp.R

class LoginActivity : AppCompatActivity() {

    private var host: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        host = Navigation.findNavController(this, R.id.container)
    }
}