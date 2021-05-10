package mykotlin.andriodatc.usstatecapitalsquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }

    fun returnToMenu(view: View) {
        var menuIntent = Intent(this, MainActivity::class.java)
        startActivity(menuIntent)
    }


}

