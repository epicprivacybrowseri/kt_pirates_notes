package ua.com.anyapps.kt_pirates_notes.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import ua.com.anyapps.kt_pirates_notes.room.dao.NoteDAO
import javax.inject.Singleton


@Module(includes = arrayOf(AppModule::class))
class RoomModule() {

    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context): AppDatabase = Room.databaseBuilder(context,
        //AppDatabase::class.java, "database").allowMainThreadQueries().build()
            AppDatabase::class.java, AppDatabase.DB_NAME).build()

    @Singleton
    @Provides
    fun provideDAO(appDatabase: AppDatabase) = appDatabase.noteDAO()

}