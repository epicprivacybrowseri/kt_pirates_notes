package ua.com.anyapps.kt_pirates_notes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlobalScope.launch(Dispatchers.Default) {
            val context: Context = this@SplashScreen
            Thread.sleep(context.resources.getInteger(R.integer.delay_splash_screen_ms).toLong())
            startActivity(Intent(context, MainActivity::class.java))
            finish()
        }
    }
}