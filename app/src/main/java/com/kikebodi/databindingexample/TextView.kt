package com.kikebodi.databindingexample

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("numberInput")
fun TextView.numberInput(number: Int){
    text = number.toString()
}