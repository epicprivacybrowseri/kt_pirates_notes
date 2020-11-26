package ua.com.anyapps.kt_pirates_notes.contract

import androidx.lifecycle.MutableLiveData
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.room.dao.NoteDAO

interface MainActivityContract {
    interface Repository1{
        fun getNotes(): MutableList<Note>
        fun getById(id: String): Note
        fun insert(note: Note)
    }

    interface AddNoteViewModel1{
        fun btnSaveNoteClicked(note: Note)
    }

    interface ListOfNotesViewModel1{
        fun loadNotesList()
    }
    /*interface Repository{
        fun insert(user: User)
        fun getAll(): LiveData<List<User>>
        fun delete(user: User)
        fun update(user: User)
    }

    interface ViewModel{
        fun generateReport ()
        fun deleteUser(user: User?)
        fun deleteUserFromRepository(user: User?)
    }

    interface Model{
        //
    }

    interface View{
        //
    }

https://github.com/karntrehan/Nagar/tree/master/app/src/main/java/com/karntrehan/nagar
https://github.com/emedinaa/kotlin-mvvm/blob/master/KotlinMVVM/app/src/main/java/com/emedinaa/kotlinmvvm/viewmodel/MuseumViewModel.kt




    https://www.raywenderlich.com/636803-mvvm-and-databinding-android-design-patterns
    https://proandroiddev.com/mvvm-with-kotlin-android-architecture-components-dagger-2-retrofit-and-rxandroid-1a4ebb38c699
    https://proandroiddev.com/mvp-to-mvvm-transformation-611959d5e0ca
    https://github.com/epicprivacybrowseri/kt_pirates_notes/tree/master/app/src/main/java/ua/com/anyapps/kt_pirates_notes
    https://levelup.gitconnected.com/a-tutorial-on-building-a-splash-screen-with-kotlin-in-android-studio-dc647cd52f9b
    https://www.geeksforgeeks.org/how-to-create-a-splash-screen-in-android-using-kotlin/
    https://medium.com/@karenmartirosyan_64397/how-to-create-a-clean-splash-screen-with-mvvm-pattern-kotlin-coroutines-328e579f3524*/
}