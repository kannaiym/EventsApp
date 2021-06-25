package com.example.eventsapp.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventsapp.data.base.BaseEvent
import com.example.eventsapp.data.base.BaseViewModel
import com.example.eventsapp.data.model.UserModel
import com.example.eventsapp.repository.EventsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: EventsRepository): BaseViewModel<BaseEvent>() {

    val userData = MutableLiveData<UserModel>()

    init {
        loadUser()
    }

    fun loadUser() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = repository.loadUser()
                userData.postValue(result?.body())
            }.onFailure {
            }
        }
    }
}
