package com.kikebodi.databindingexample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.kikebodi.databindingexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val vm = MainViewModel().also {
        it.number.observe(this, Observer<Int> { amount ->
            Toast.makeText(this@MainActivity, "Amount selected: $amount", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = ActivityMainBinding.inflate(layoutInflater).apply {
            activity = this@MainActivity
        }
        setContentView(view.root)
    }
}
