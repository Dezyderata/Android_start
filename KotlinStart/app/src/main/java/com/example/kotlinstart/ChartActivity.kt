package com.example.kotlinstart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import java.util.*

class ChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        val button_back = findViewById<Button>(R.id.back)
        button_back.setOnClickListener(View.OnClickListener {
            launchMainActivity()
        })

        val pie = AnyChart.pie()

        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry("Zgony", 284034))
        data.add(ValueDataEntry("Wyleczeni", 1500385))
        data.add(ValueDataEntry("Chorzy", 4196784))

        pie.data(data)

        val anyChartView =
            findViewById<View>(R.id.any_chart_view) as AnyChartView
        anyChartView.setChart(pie)
    }

    fun launchMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
