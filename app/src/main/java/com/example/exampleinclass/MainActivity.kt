package com.example.exampleinclass

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.bai1_layout)

        val input: EditText = findViewById(R.id.input)
        val output: TextView = findViewById(R.id.output)
        val showBtn: Button = findViewById(R.id.showBtn)

        val listView : ListView = findViewById(R.id.listView)

        val even: RadioButton = findViewById(R.id.evenBtn)
        val odd: RadioButton = findViewById(R.id.oddBtn)
        val square: RadioButton = findViewById(R.id.squareBtn)

        showBtn.setOnClickListener {
            val inputText = input.text.toString()

            if (inputText.isEmpty() || inputText.toIntOrNull() == null) {
                output.text = "Vui lòng nhập một số nguyên dương hợp lệ"
                output.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

            val n = inputText.toInt()
            output.visibility = TextView.GONE
            val result = mutableListOf<Int>()

            when {
                even.isChecked -> {
                    for (i in 0..n step 2) result.add(i)
                }

                odd.isChecked -> {
                    for (i in 1..n step 2) result.add(i)
                }

                square.isChecked -> {
                    var i = 0
                    while (i * i <= n) {
                        result.add(i * i)
                        i++
                    }
                }
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, result)
            listView.adapter = adapter
        }
    }
}