package ua.com.anyapps.kt_pirates_notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val TAG: String = "debapp"
    lateinit var host: NavHostFragment
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        host = notes_nav_host_fragment as NavHostFragment
        navController = host.navController
        notes_list_bottom_menu.setupWithNavController(navController)

        /*dfgfdg
        host = supportFragmentManager
            .findFragmentById(R.id.notes_nav_host_fragment) as NavHostFragment? ?: return
        navController = host.navController
dfgfdg*/
        /*val bottomNav = findViewById<BottomNavigationView>(R.id.notes_list_bottom_menu)
        bottomNav?.setupWithNavController(navController)*/

    }


    fun btnClick(view: View) {
        navController.navigate(R.id.addNoteFragment)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_current_workout -> {
                i.setClass(this, CurrentWorkoutActivity::class.java)
                startActivity(i)
            }
            R.id.nav_log -> {
                //similarly start activity with Intent
            }
            else ->super.onOptionsItemSelected(item)
        }
        return true
    }
}