package ua.com.anyapps.kt_pirates_notes.di.component

import dagger.Component
import ua.com.anyapps.kt_pirates_notes.di.module.AppModule
import ua.com.anyapps.kt_pirates_notes.di.module.RoomModule
import ua.com.anyapps.kt_pirates_notes.repository.Repository
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AppModule::class, RoomModule::class))
interface ApplicationComponent {
    fun inject(into: Repository)
}