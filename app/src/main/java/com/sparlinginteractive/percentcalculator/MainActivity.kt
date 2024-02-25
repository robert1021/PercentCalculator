package com.sparlinginteractive.percentcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNumberPercent: EditText
    private lateinit var editTextNumberOfPercent: EditText
    private lateinit var textViewPercentAnswer: TextView
    private lateinit var buttonCalculatePercent1: Button
    private lateinit var buttonClearPercent1: Button
    private val calculatePercent = CalculatePercent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumberPercent = findViewById(R.id.editTextNumberPercent)
        editTextNumberOfPercent = findViewById(R.id.editTextNumberOfPercent)
        textViewPercentAnswer = findViewById(R.id.textViewPercentAnswer)
        buttonCalculatePercent1 = findViewById(R.id.buttonCalculatePercent1)
        buttonClearPercent1 = findViewById(R.id.buttonClearPercent1)

        buttonCalculatePercent1.setOnClickListener {handleCalculatePercent1ButtonClick()}
        buttonClearPercent1.setOnClickListener {handleClearPercent1ButtonClick()}

    }

    private fun handleCalculatePercent1ButtonClick() {
        val percent: String = editTextNumberPercent.text.toString()
        val amount: String = editTextNumberOfPercent.text.toString()

        if (!TextUtils.isEmpty(percent) && !TextUtils.isEmpty(amount)) {
            val answer: Double = calculatePercent.calculatePercentOf(percent.toDouble(), amount.toDouble())

            if (answer % 1.0 == 0.0) {
                textViewPercentAnswer.text = answer.toInt().toString()
            } else {
                textViewPercentAnswer.text = String.format("%.2f", answer)
            }
        }
    }

    private fun handleClearPercent1ButtonClick() {
        editTextNumberPercent.setText("")
        editTextNumberOfPercent.setText("")
        textViewPercentAnswer.text = ""
    }



}