package com.example.kotlinstart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.chart).setOnClickListener(View.OnClickListener {
            launchChartActivity()
        })
        findViewById<Button>(R.id.bmi).setOnClickListener(View.OnClickListener {
            launchBMIActivity()
        })
        findViewById<Button>(R.id.quiz).setOnClickListener(View.OnClickListener {
            launchQuizActivity()
        })
    }
    fun launchChartActivity(){
        val intent = Intent(this, ChartActivity::class.java)
        startActivity(intent)
    }
    fun launchBMIActivity(){
        val intent = Intent(this, BmiActivity::class.java)
        startActivity(intent)
    }
    fun launchQuizActivity(){
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

}
