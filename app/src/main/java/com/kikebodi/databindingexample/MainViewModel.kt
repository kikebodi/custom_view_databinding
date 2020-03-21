package com.kikebodi.databindingexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val number = MutableLiveData<Int>()
}