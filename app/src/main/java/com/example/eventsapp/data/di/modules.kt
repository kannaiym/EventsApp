package com.example.eventsapp.data.di

import com.example.eventsapp.data.remote.*
import com.example.eventsapp.interactor.EventsInteractor
import com.example.eventsapp.interactor.EventsInteractorImpl
import com.example.eventsapp.repository.EventsRepository
import com.example.eventsapp.repository.EventsRepositoryImpl
import com.example.eventsapp.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import java.lang.reflect.Array.get

val viewModelModule: Module = module {
    viewModel { ProfileViewModel(get()) }
}

val repositoryModule: Module = module {
    factory <EventsRepository> { EventsRepositoryImpl(get()) }
    factory { EventsInteractorImpl(get()) }
}

val apiModule: Module = module {
    single { provideOkHttpClient(get()) }
    single { provideEventService(get()) }
    single { provideHttpLoginingInterceptor() }
    single { RetrofitClient(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)

