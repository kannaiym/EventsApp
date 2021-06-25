package com.example.eventsapp.repository

import com.example.eventsapp.data.model.UserModel
import com.example.eventsapp.interactor.EventsInteractor
import retrofit2.Response

interface EventsRepository {
    suspend fun loadUser(): Response<UserModel>
}

class EventsRepositoryImpl(private val network: EventsInteractor) : EventsRepository {
    override suspend fun loadUser(): Response<UserModel> {
        return network.loadUser()
    }
}
