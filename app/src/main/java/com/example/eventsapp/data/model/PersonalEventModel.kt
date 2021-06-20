package com.example.eventsapp.data.model

import com.example.eventsapp.R

data class PersonalEventModel(
    val image:Int,
    val title:String
)

fun getCourses(): MutableList<PersonalEventModel> {
    return mutableListOf<PersonalEventModel>().apply {
        add(PersonalEventModel(R.drawable.face, "Event"))
        add(PersonalEventModel(R.drawable.face, "Event"))
        add(PersonalEventModel(R.drawable.face, "Event"))
        add(PersonalEventModel(R.drawable.face, "Event"))
    }
}