package com.example.eventsapp.interactor

import com.example.eventsapp.data.model.UserModel
import com.example.eventsapp.data.remote.EventsService
import retrofit2.Response

interface EventsInteractor {
    suspend fun loadUser(): Response<UserModel>
}
class EventsInteractorImpl(private val service: EventsService) : EventsInteractor {
    override suspend fun loadUser(): Response<UserModel> {
        return service.loadUser()
    }
}