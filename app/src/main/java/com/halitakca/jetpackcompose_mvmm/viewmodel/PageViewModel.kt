package com.halitakca.jetpackcompose_mvmm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.halitakca.jetpackcompose_mvmm.MathRepository

class PageViewModel : ViewModel() {
    var result = MutableLiveData<String>()
    var mrepo = MathRepository()

    init {
        result = mrepo.getMathResult()
    }

    fun sum(number1: String, number2: String) {
        mrepo.sum(number1, number2)
    }

    fun multiply(number1: String, number2: String) {
        mrepo.multiply(number1, number2)
    }

}

/*      val number1 = number1.toInt()
        val number2 = number2.toInt()
        val sum = number1 + number2
        //result = sum.toString()
        result.value = sum.toString()
 */
/*
        val number1 = number1.toInt()
        val number2 = number2.toInt()
        val mul = number1 * number2
        //result = mul.toString()
        result.value = mul.toString()
 */