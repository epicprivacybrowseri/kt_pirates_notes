package ua.com.anyapps.kt_pirates_notes.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule constructor(_application: Application) {
    var application: Application? = null

    init{
        application = _application
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application!!
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application!!
    }
}