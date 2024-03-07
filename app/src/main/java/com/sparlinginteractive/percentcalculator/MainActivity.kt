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
    private lateinit var editTextValue1: EditText
    private lateinit var editTextValue2: EditText
    private lateinit var textViewPercentAnswer2: TextView
    private lateinit var buttonCalculatePercent2: Button
    private lateinit var buttonClearPercent2: Button
    private lateinit var linearLayoutPercentIncrease: LinearLayout
    private lateinit var editTextValue3: EditText
    private lateinit var editTextValue4: EditText
    private lateinit var textViewPercentAnswer3: TextView
    private lateinit var buttonCalculatePercent3: Button
    private lateinit var buttonClearPercent3: Button
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
        editTextValue1 = findViewById(R.id.editTextValue1)
        editTextValue2 = findViewById(R.id.editTextValue2)
        textViewPercentAnswer2 = findViewById(R.id.textViewPercentAnswer2)
        buttonCalculatePercent2 = findViewById(R.id.buttonCalculatePercent2)
        buttonClearPercent2 = findViewById(R.id.buttonClearPercent2)

        linearLayoutPercentIncrease = findViewById(R.id.linearLayoutPercentIncrease)
        editTextValue3 = findViewById(R.id.editTextValue3)
        editTextValue4 = findViewById(R.id.editTextValue4)
        textViewPercentAnswer3 = findViewById(R.id.textViewPercentAnswer3)
        buttonCalculatePercent3 = findViewById(R.id.buttonCalculatePercent3)
        buttonClearPercent3 = findViewById(R.id.buttonClearPercent3)
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

        // Buttons
        buttonCalculatePercent1.setOnClickListener {handleCalculatePercent1ButtonClick()}
        buttonClearPercent1.setOnClickListener {handleClearPercent1ButtonClick()}
        buttonCalculatePercent2.setOnClickListener {handleCalculatePercent2ButtonClick()}
        buttonClearPercent2.setOnClickListener {handleClearPercent2ButtonClick()}
        buttonCalculatePercent3.setOnClickListener {handleCalculatePercent3ButtonClick()}
        buttonClearPercent3.setOnClickListener {handleClearPercent3ButtonClick()}

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

    private fun handleCalculatePercent2ButtonClick() {
        val value1: String = editTextValue1.text.toString()
        val value2: String = editTextValue2.text.toString()

        if (!TextUtils.isEmpty(value1) && !TextUtils.isEmpty(value2)) {
            val answer: Double = calculatePercent.calculatePercentDifference(value1.toDouble(), value2.toDouble())

            if (answer % 1.0 == 0.0) {
                val formattedText = "${answer.toInt()}%"
                textViewPercentAnswer2.text = formattedText
            } else {
                val formattedText = "${String.format("%.2f", answer)}%"
                textViewPercentAnswer2.text = formattedText
            }
        }
    }

    private fun handleClearPercent2ButtonClick() {
        editTextValue1.setText("")
        editTextValue2.setText("")
        textViewPercentAnswer2.text = ""
    }

    private fun handleCalculatePercent3ButtonClick() {
        val value1: String = editTextValue3.text.toString()
        val value2: String = editTextValue4.text.toString()

        if (!TextUtils.isEmpty(value1) && !TextUtils.isEmpty(value2)) {
            val answer: Double = calculatePercent.calculatePercentIncrease(value1.toDouble(), value2.toDouble())

            if (answer % 1.0 == 0.0) {
                val formattedText = "${answer.toInt()}%"
                textViewPercentAnswer3.text = formattedText
            } else {
                val formattedText = "${String.format("%.2f", answer)}%"
                textViewPercentAnswer3.text = formattedText
            }
        }
    }

    private fun handleClearPercent3ButtonClick() {
        editTextValue3.setText("")
        editTextValue4.setText("")
        textViewPercentAnswer3.text = ""
    }


}