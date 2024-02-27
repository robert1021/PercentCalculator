package com.sparlinginteractive.percentcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton
    private lateinit var radio4: RadioButton
    private lateinit var linearLayoutPercentOfNumber: LinearLayout
    private lateinit var editTextNumberPercent: EditText
    private lateinit var editTextNumberOfPercent: EditText
    private lateinit var textViewPercentAnswer: TextView
    private lateinit var buttonCalculatePercent1: Button
    private lateinit var buttonClearPercent1: Button
    private val calculatePercent = CalculatePercent()
    private lateinit var linearLayoutPercentDifference: LinearLayout
    private lateinit var linearLayoutPercentIncrease: LinearLayout
    private lateinit var linearLayoutPercentDecrease: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radioGroup)
        radio1 = findViewById(R.id.radioButton1)
        radio2 = findViewById(R.id.radioButton2)
        radio3 = findViewById(R.id.radioButton3)
        radio4 = findViewById(R.id.radioButton4)

        linearLayoutPercentOfNumber = findViewById(R.id.linearLayoutPercentOfNumber)
        editTextNumberPercent = findViewById(R.id.editTextNumberPercent)
        editTextNumberOfPercent = findViewById(R.id.editTextNumberOfPercent)
        textViewPercentAnswer = findViewById(R.id.textViewPercentAnswer)
        buttonCalculatePercent1 = findViewById(R.id.buttonCalculatePercent1)
        buttonClearPercent1 = findViewById(R.id.buttonClearPercent1)

        linearLayoutPercentDifference = findViewById(R.id.linearLayoutPercentDifference)
        linearLayoutPercentIncrease = findViewById(R.id.linearLayoutPercentIncrease)
        linearLayoutPercentDecrease = findViewById(R.id.linearLayoutPercentDecrease)

        radioGroup.setOnCheckedChangeListener {group, checkedId ->
            linearLayoutPercentOfNumber.visibility = View.GONE
            linearLayoutPercentDifference.visibility = View.GONE
            linearLayoutPercentIncrease.visibility = View.GONE
            linearLayoutPercentDecrease.visibility = View.GONE

            when (checkedId) {
                R.id.radioButton1 -> linearLayoutPercentOfNumber.visibility = View.VISIBLE
                R.id.radioButton2 -> linearLayoutPercentDifference.visibility = View.VISIBLE
                R.id.radioButton3 -> linearLayoutPercentIncrease.visibility = View.VISIBLE
                R.id.radioButton4 -> linearLayoutPercentDecrease.visibility = View.VISIBLE
            }
        }

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