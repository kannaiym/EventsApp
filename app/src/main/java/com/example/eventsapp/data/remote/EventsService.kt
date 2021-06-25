package com.example.eventsapp.data.remote

import com.example.eventsapp.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsService {

    @GET("api/users")
    suspend fun loadUser(): Response<UserModel>

}