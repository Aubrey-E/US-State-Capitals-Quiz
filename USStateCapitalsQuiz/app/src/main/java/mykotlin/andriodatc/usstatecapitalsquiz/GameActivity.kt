package mykotlin.andriodatc.usstatecapitalsquiz

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*
import java.util.*

class GameActivity : AppCompatActivity() {
    // create lists
    var statesList = arrayOf("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
        "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
        "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
        "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
        "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
        "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming")
    var capitalsList = arrayOf("Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford",
        "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka",
        "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "St. Paul", "Jackson", "Jefferson City",
        "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus",
        "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City",
        "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne")
    var imagesList = arrayOf(R.drawable.img0, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
        R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10,
        R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14, R.drawable.img15, R.drawable.img16,
        R.drawable.img17, R.drawable.img18, R.drawable.img19, R.drawable.img20, R.drawable.img21, R.drawable.img22,
        R.drawable.img23, R.drawable.img24, R.drawable.img25, R.drawable.img26, R.drawable.img27, R.drawable.img28,
        R.drawable.img29, R.drawable.img30, R.drawable.img31, R.drawable.img32, R.drawable.img33, R.drawable.img34,
        R.drawable.img35, R.drawable.img36, R.drawable.img37, R.drawable.img38, R.drawable.img39, R.drawable.img40,
        R.drawable.img41, R.drawable.img42, R.drawable.img43, R.drawable.img44, R.drawable.img45, R.drawable.img46,
        R.drawable.img47, R.drawable.img48, R.drawable.img49)
    var indexesList = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 ,18, 19, 20, 21, 22, 23, 24, 25,
        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49)
    val PREF_NAME = "myPrefs"
    //variables needed for timed
    var begin = 0
    var end = 0
    var isTimed = false

    //create count variable that can be incremented after each question
    var count = 0
    var correctAnswers = 0
    var incorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var databack: SharedPreferences = getSharedPreferences(PREF_NAME, 0)
        databack = getSharedPreferences(PREF_NAME, 0)
        //start a timer, if timed has been selected in preferences
        if (databack.contains("timed") && databack.getBoolean("timed", false)) {
            begin = Date().time.toInt()
            isTimed = true
        }
        //shuffle the indexes to show questions in random order, if random has been selected in preferences
        if (databack.contains("random") && databack.getBoolean("random", false)) {
            indexesList.shuffle()
            showQuestion()
        } else {
            //call showQuestion function for first question
            showQuestion()
        }
    }

    //function that will show question on the screen
    fun showQuestion() {
        //show the question text
        question.text = "What is the capital of " + (statesList[indexesList[count]] + "?")
        //show image
        stateImage.setImageResource(imagesList[indexesList[count]])

        //get random numbers to randomize answer choices
        var correctChoice = (1..4).random()
        var incorrect1 = (0..49).random()
        var incorrect2 = (0..49).random()
        var incorrect3 = (0..49).random()

        //make sure the incorrect answers are not the same as the correct answer

        while (incorrect1 == indexesList[count] || incorrect2 == indexesList[count] || incorrect3 == indexesList[count]) {
        incorrect1 = (0..49).random()
        incorrect2 = (0..49).random()
        incorrect3 = (0..49).random() }

        if (correctChoice == 1) {
            option1.text = capitalsList[indexesList[count]]
            option2.text = capitalsList[incorrect1]
            option3.text = capitalsList[incorrect2]
            option4.text = capitalsList[incorrect3]
        }
        else if (correctChoice == 2) {
            option2.text = capitalsList[indexesList[count]]
            option1.text = capitalsList[incorrect1]
            option3.text = capitalsList[incorrect2]
            option4.text = capitalsList[incorrect3]
        }
        else if (correctChoice == 3) {
            option3.text = capitalsList[indexesList[count]]
            option1.text = capitalsList[incorrect1]
            option2.text = capitalsList[incorrect2]
            option4.text = capitalsList[incorrect3]
        }
        else {
                option4.text = capitalsList[indexesList[count]]
                option1.text = capitalsList[incorrect1]
                option3.text = capitalsList[incorrect2]
                option2.text = capitalsList[incorrect3]
        }


    }

    //process the answer if first button was clicked
    fun processAnswer1(view: View) {
        var answer = option1.text
        if (answer == capitalsList[indexesList[count]]) {
            correctAnswers += 1
        }
        else {
            incorrectAnswers += 1
        }

        loadNext()
    }
    //process the answer if second button was clicked
    fun processAnswer2(view: View) {
        var answer = option2.text
        if (answer == capitalsList[indexesList[count]]) {
            correctAnswers += 1
        }
        else {
            incorrectAnswers += 1
        }

        loadNext()
    }
    //process the answer if third button was clicked
    fun processAnswer3(view: View) {
        var answer = option3.text
        if (answer == capitalsList[indexesList[count]]) {
            correctAnswers += 1
        }
        else {
            incorrectAnswers += 1
        }

        loadNext()

    }
    //process the answer if fourth button was clicked
    fun processAnswer4(view: View) {
        var answer = option4.text
        if (answer == capitalsList[indexesList[count]]) {
            correctAnswers += 1
        }
        else {
            incorrectAnswers += 1
        }

        loadNext()

    }

    fun loadNext() {
        //call the next question, or switch screens at end
        count += 1
        if (count < 50) {
            showQuestion()
        }
        else {
            //create intent
            var endIntent = Intent(this, EndActivity:: class.java)

           //add data to intent
            endIntent.putExtra("correctAnswers", correctAnswers)
            endIntent.putExtra("incorrectAnswers", incorrectAnswers)
            //end timer
            if (isTimed) {
                end = Date().time.toInt()
                var time = end - begin
                endIntent.putExtra("time", time)
            }
            startActivity(endIntent)
        }
    }



}