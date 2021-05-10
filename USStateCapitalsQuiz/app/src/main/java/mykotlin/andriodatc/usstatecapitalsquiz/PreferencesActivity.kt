package mykotlin.andriodatc.usstatecapitalsquiz

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_preferences.*

class PreferencesActivity : AppCompatActivity() {

    val PREF_NAME = "myPrefs"
    var myPref: SharedPreferences?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        applybutton.setOnClickListener {
            myPref = getSharedPreferences(PREF_NAME, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences).edit()

            //save values
            if(!TextUtils.isEmpty(nameinput.text)) {
                editor.putString("name", nameinput.text.toString())
            }
            editor.putBoolean("timed", timedswitch.isChecked)
            editor.putBoolean("random", randomswitch.isChecked)
            editor.commit()
        }
        //display saved values
        var databack: SharedPreferences = getSharedPreferences(PREF_NAME, 0)
        databack = getSharedPreferences(PREF_NAME, 0)
        if(databack.contains("name")) {
            nameinput.setText(databack.getString("name", ""))
        }
        if(databack.contains("timed")) {
            timedswitch.isChecked = databack.getBoolean("timed", false)
        }
        if (databack.contains("random")) {
            randomswitch.isChecked = databack.getBoolean("random", false)
        }
    }



    fun returnToMenu(view: View) {
        var menuIntent = Intent(this, MainActivity::class.java)
        startActivity(menuIntent)
    }
}