package com.example.kotlinstart


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BmiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        var sex = 0
        val radioGroup = findViewById<View>(R.id.sex) as RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val checkedSex =
                findViewById<View>(checkedId) as RadioButton
            sex = radioGroup.indexOfChild(checkedSex)
            println("moj sex: $sex")
        }

        val button_count = findViewById<Button>(R.id.count)
        button_count.setOnClickListener(View.OnClickListener {
            countBmiAndCalories(sex)
        })
        val button_back = findViewById<Button>(R.id.back)
        button_back.setOnClickListener(View.OnClickListener {
            launchMainActivity()
        })
    }

    fun countBmiAndCalories(sex: Int){
        val heightText = findViewById<EditText>(R.id.height).text.toString()
        val massText = findViewById<EditText>(R.id.mass).text.toString()
        val ageText = findViewById<EditText>(R.id.age).text.toString()
        println("Moje teksty Your Highnes: $heightText, masa: $massText, age: $ageText")
        try {
            val height: Double = heightText.toDouble()
            val mass: Int = massText.toInt()
            val age: Int = ageText.toInt()
            println("Your Highnes: $height, masa: $mass, age: $age")
            if (sex == 0 && age != 0) {
                val calories = 655.1 + (9.567 * mass) + (1.85 * height * 100.0) - (4.68 * age)
                findViewById<TextView>(R.id.calories).setText(calories.toString())
            }else if(sex == 1 && age != 0){
                val calories =  66.47 + 13.7 * mass + 5.0 * height * 100.0 - 6.76 * age;
                findViewById<TextView>(R.id.calories).setText(calories.toString())
            }else{
                findViewById<TextView>(R.id.calories).setText("Brak danych")
            }
            val BMI = mass/(height * height)
            findViewById<TextView>(R.id.score).setText(BMI.toString()+setBmiText(BMI))
        }catch (e: NumberFormatException){
            Toast.makeText(this, "Złe dane", Toast.LENGTH_SHORT).show()
        }
    }
    fun launchMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun setBmiText(bmi: Double): String {
        if (bmi <= 18.5){
            return " Zjedz coś!"
        }else if(bmi > 25.0){
            return " Czas poćwiczyć!"
        }else{
            return " Luzik!"
        }
    }
}
