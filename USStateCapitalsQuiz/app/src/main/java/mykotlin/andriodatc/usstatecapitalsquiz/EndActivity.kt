package mykotlin.andriodatc.usstatecapitalsquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_end.*

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        //get data from game activity
        var intent = getIntent()
        var correctAnswers = intent.getIntExtra("correctAnswers", -1)
        var incorrectAnswers = intent.getIntExtra("incorrectAnswers", -1)
        var time = intent.getIntExtra("time", -1)

        var percentCorrect = (correctAnswers / 50.0 * 100).toInt()

        result.text = "Correct: " + correctAnswers + "  Incorrect: " + incorrectAnswers


        percent.text = percentCorrect.toString() + "%"
        if (time != -1) {
            time = time/1000
            var minutes = time / 60
            var seconds = time % 60
            timeText.text = "Your time was " + minutes.toString() + ":" + seconds.toString()
        }
        if (percentCorrect == 0) {
            message.text = "You're either really unlucky or you know all the answers and avoided them..."
        } else if (percentCorrect < 50) {
            message.text = "You are on your way to becoming a master of the state capitals. Keep trying!"
        } else if (percentCorrect < 85) {
            message.text = "Congratulations! Your knowledge of the state capitals is pretty good."
        } else if (percentCorrect > 99) {
            message.text = "Wow! A perfect 100%! You're a master of the state capitals."
        } else {
            message.text = "Congratulations! You've got great state capital knowledge. Can you get 100%?"
        }
    }

    fun startGame(view: View) {
        var gameIntent = Intent(this, GameActivity::class.java)
        startActivity(gameIntent)
    }

    fun returnToMenu(view: View) {
        var menuIntent = Intent(this, MainActivity::class.java)
        startActivity(menuIntent)
    }
}