
package com.example.bmicalculator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.text.DecimalFormat

class BmiViewModel : ViewModel() {

    var heightInput by mutableStateOf("")
        private set

    var weightInput by mutableStateOf("")
        private set

    private val formatter = DecimalFormat("0.00")


    val bmi: String
        get() {
            val height = heightInput.toFloatOrNull() ?: 0f
            val weight = weightInput.toFloatOrNull() ?: 0f
            return if (height > 0 && weight > 0) {
                formatter.format(weight / (height * height))
            } else {
                "0.00"
            }
        }

    fun onHeightChange(newHeight: String) {
        heightInput = newHeight.replace(',', '.')
    }

    fun onWeightChange(newWeight: String) {
        weightInput = newWeight.replace(',', '.')
    }
}
