package com.halitakca.jetpackcompose_mvmm.viewmodel

import androidx.lifecycle.ViewModel

class PageViewModel : ViewModel() {
    var result = "0"

    fun sum(number1: String, number2: String){
        val number1 = number1.toInt()
        val number2 = number2.toInt()
        val sum = number1 + number2
        result = sum.toString()
    }

    fun multiply(number1: String, number2: String){
        val number1 = number1.toInt()
        val number2 = number2.toInt()
        val mul = number1 * number2
        result = mul.toString()
    }

}