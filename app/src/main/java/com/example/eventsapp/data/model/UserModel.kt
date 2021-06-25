package com.example.eventsapp.data.model

import java.util.*

data class UserModel(
    val id: Int,
    val fullName: String,
    val dateOfBirth: Int,
    val number: Int,
    val gender: String,
    val email: String,
    val creationDate: Date,
    val password: Int,
    val photoID: Int,
    val login: String
)