package mykotlin.andriodatc.usstatecapitalsquiz

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREF_NAME = "myPrefs"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create welcome message
        var databack: SharedPreferences = getSharedPreferences(PREF_NAME, 0)
        databack = getSharedPreferences(PREF_NAME, 0)

        if (databack.contains("name")) {
            welcome.text = "Welcome back, " + databack.getString("name", "") + "!"
        } else {
            welcome.text = "Welcome back!"
        }
    }

    //function to call the secondary activity (game activity)
    fun startGame(view: View) {
        var gameIntent = Intent(this, GameActivity::class.java)
        startActivity(gameIntent)
    }

    fun help(view: View) {
        var helpIntent = Intent(this, HelpActivity::class.java)
        startActivity(helpIntent)
    }

    fun preferences(view: View) {
        var preferencesIntent = Intent(this, PreferencesActivity::class.java)
        startActivity(preferencesIntent)
    }


}