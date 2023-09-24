package com.halitakca.jetpackcompose_mvmm

import androidx.lifecycle.MutableLiveData

class MathRepository {
   // ERROR: Clash Error verdi: var mathResult = MutableLiveData<String>()
   private var mathResult = MutableLiveData<String>()

    init {
        mathResult = MutableLiveData<String>("0")
    }

    fun getMathResult():MutableLiveData<String>{
        return mathResult
    }

    fun sum(number1: String, number2: String){
        val number1 = number1.toInt()
        val number2 = number2.toInt()
        val sum = number1 + number2
        //result = sum.toString()
        mathResult.value = sum.toString()
    }

    fun multiply(number1: String, number2: String){
        val number1 = number1.toInt()
        val number2 = number2.toInt()
        val mul = number1 * number2
        //result = mul.toString()
        mathResult.value = mul.toString()

    }
}