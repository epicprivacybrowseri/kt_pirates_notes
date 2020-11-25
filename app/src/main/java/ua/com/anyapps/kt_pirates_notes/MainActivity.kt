package ua.com.anyapps.kt_pirates_notes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import ua.com.anyapps.kt_pirates_notes.model.Noote
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import ua.com.anyapps.kt_pirates_notes.room.dao.NoteDAO


class MainActivity : AppCompatActivity(){
    val TAG: String = "debapp"
    lateinit var host: NavHostFragment
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        host = notes_nav_host_fragment as NavHostFragment
        navController = host.navController
        notes_list_bottom_menu.setupWithNavController(navController)

        /*dfgfdgdf
        host = supportFragmentManager
            .findFragmentById(R.id.notes_nav_host_fragment) as NavHostFragment? ?: return
        navController = host.navController
dfgfdg*/
        /*val bottomNav = findViewById<BottomNavigationView>(R.id.notes_list_bottom_menu)
        bottomNav?.setupWithNavController(navController)*/
        //notes_list_bottom_menu.setOnNavigationItemSelectedListener(this)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database"
        ).build()
        val noteDao: NoteDAO = db.noteDAO()

        val note1: Noote = Noote(1,"Title1", "Text1")
        val note2: Noote = Noote(2,"Title2", "Text2")
        noteDao.insert(note1)
        noteDao.insert(note2)

        val list = mutableListOf<Noote>()
        noteDao.getById("1").observe(this, Observer{note:Noote?->
            Log.d(TAG, "Title: " + note?.title + " Text: " + note?.text)
        })

    }


    /*fun btnClick(view: View) {
        navController.navigate(R.id.addNoteFragment)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.listOfNotesFragment -> {
                Log.d(TAG, "List fragment")
                //getSupportActionBar()?.show()
            }
            R.id.addNoteFragment -> {
                Log.d(TAG, "Add fragment")
                //getSupportActionBar()?.hide()
                notes_list_bottom_menu.setSelectedItemId(R.id.addNoteFragment);
            }
            else -> {
                //getSupportActionBar()?.show()
                super.onOptionsItemSelected(item)
            }
        }
        //Log.d(TAG, "1111111")
        return true
    }*/
}