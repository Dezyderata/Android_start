package com.example.kotlinstart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        var virus_list = arrayListOf<VirusItem>()
        val myDB = DBVirus()
        var turn = 1
        var score = 0
        var b_odpowiedz1 = findViewById<Button>(R.id.ans1)
        var b_odpowiedz2 = findViewById<Button>(R.id.ans2)
        var b_odpowiedz3 = findViewById<Button>(R.id.ans3)
        var b_odpowiedz4 = findViewById<Button>(R.id.ans4)
        for (i in 0 until myDB.viruses.size) {
            virus_list.add(VirusItem(myDB.viruses[i], myDB.images[i]))
        }
        Collections.shuffle(virus_list)
        newQuestion(turn, virus_list)

        b_odpowiedz1.setOnClickListener(View.OnClickListener {
            if(b_odpowiedz1.getText().toString().equals(virus_list.get(turn - 1).name)){
                Toast.makeText(this@QuizActivity, "Zgadza sie!", Toast.LENGTH_SHORT).show()
                score++
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            } else {
                Toast.makeText(this@QuizActivity, "Nie tym razem!", Toast.LENGTH_SHORT).show()
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }
        })
        b_odpowiedz2.setOnClickListener {
            if (b_odpowiedz2.text.toString()
                    .equals(virus_list[turn - 1].name, ignoreCase = true)
            ) {
                Toast.makeText(this@QuizActivity, "Zgadza sie!", Toast.LENGTH_SHORT).show()
                score++
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            } else {
                Toast.makeText(this@QuizActivity, "Nie tym razem!", Toast.LENGTH_SHORT).show()
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }
        }
        b_odpowiedz3.setOnClickListener {
            if (b_odpowiedz3.text.toString()
                    .equals(virus_list[turn - 1].name, ignoreCase = true)
            ) {
                Toast.makeText(this@QuizActivity, "Zgadza sie!", Toast.LENGTH_SHORT).show()
                score++
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            } else {
                Toast.makeText(this@QuizActivity, "Nie tym razem!", Toast.LENGTH_SHORT).show()
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }
        }
        b_odpowiedz4.setOnClickListener {
            if (b_odpowiedz4.text.toString()
                    .equals(virus_list[turn - 1].name, ignoreCase = true)
            ) {
                Toast.makeText(this@QuizActivity, "Zgadza sie!", Toast.LENGTH_SHORT).show()
                score++
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            } else {
                Toast.makeText(this@QuizActivity, "Nie tym razem!", Toast.LENGTH_SHORT).show()
                if (turn < virus_list.size) {
                    turn++
                    newQuestion(turn, virus_list)
                } else {
                    Toast.makeText(
                        this@QuizActivity,
                        "Skonczyles gre z wynikiem: $score",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }
        }



        findViewById<Button>(R.id.back).setOnClickListener(View.OnClickListener {
            launchMainActivity()
        })
    }
    fun launchMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun newQuestion(number: Int, virus_list: ArrayList<VirusItem>) {
        findViewById<ImageView>(R.id.vir_image).setImageResource(virus_list.get(number - 1).image)
        val correct_ans: Int = Random().nextInt(4) + 1
        val firstButton = number - 1
        var secondButton: Int
        var thirdButton: Int
        var forthButton: Int
        when (correct_ans) {
            1 -> {
                findViewById<Button>(R.id.ans1).setText(virus_list.get(firstButton).name)
                do {
                    secondButton = Random().nextInt(virus_list.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = Random().nextInt(virus_list.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    forthButton = Random().nextInt(virus_list.size)
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton)
                findViewById<Button>(R.id.ans2).setText(virus_list.get(secondButton).name)
                findViewById<Button>(R.id.ans3).setText(virus_list.get(thirdButton).name)
                findViewById<Button>(R.id.ans4).setText(virus_list.get(forthButton).name)
            }
            2 -> {
                findViewById<Button>(R.id.ans2).setText(virus_list.get(firstButton).name)
                do {
                    secondButton = Random().nextInt(virus_list.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = Random().nextInt(virus_list.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    forthButton = Random().nextInt(virus_list.size)
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton)
                findViewById<Button>(R.id.ans1).setText(virus_list.get(secondButton).name)
                findViewById<Button>(R.id.ans3).setText(virus_list.get(thirdButton).name)
                findViewById<Button>(R.id.ans4).setText(virus_list.get(forthButton).name)
            }
            3 -> {
                findViewById<Button>(R.id.ans3).setText(virus_list.get(firstButton).name)
                do {
                    secondButton = Random().nextInt(virus_list.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = Random().nextInt(virus_list.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    forthButton = Random().nextInt(virus_list.size)
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton)
                findViewById<Button>(R.id.ans2).setText(virus_list.get(secondButton).name)
                findViewById<Button>(R.id.ans1).setText(virus_list.get(thirdButton).name)
                findViewById<Button>(R.id.ans4).setText(virus_list.get(forthButton).name)
            }
            4 -> {
                findViewById<Button>(R.id.ans4).setText(virus_list.get(firstButton).name)
                do {
                    secondButton = Random().nextInt(virus_list.size)
                } while (secondButton == firstButton)
                do {
                    thirdButton = Random().nextInt(virus_list.size)
                } while (thirdButton == firstButton || thirdButton == secondButton)
                do {
                    forthButton = Random().nextInt(virus_list.size)
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton)
                findViewById<Button>(R.id.ans2).setText(virus_list.get(secondButton).name)
                findViewById<Button>(R.id.ans3).setText(virus_list.get(thirdButton).name)
                findViewById<Button>(R.id.ans1).setText(virus_list.get(forthButton).name)
            }
        }
    }
}
