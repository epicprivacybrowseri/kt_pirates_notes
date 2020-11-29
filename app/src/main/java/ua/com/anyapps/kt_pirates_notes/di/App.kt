package ua.com.anyapps.kt_pirates_notes.di

import android.app.Application
import ua.com.anyapps.kt_pirates_notes.di.component.ApplicationComponent
import ua.com.anyapps.kt_pirates_notes.di.component.DaggerApplicationComponent
import ua.com.anyapps.kt_pirates_notes.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        initializeDagger()
    }

    private fun initializeDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getApplciationComponent(): ApplicationComponent {
        return applicationComponent
    }
}