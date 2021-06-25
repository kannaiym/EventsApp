package com.example.eventsapp.data.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

sealed class BaseEvent {

}

open class BaseViewModel<EVENT: BaseEvent> : ViewModel() {
    var loading = MutableLiveData<Boolean>()
}