package com.example.applicationactivities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity(R.layout.activity_second) {

    private val ttPhone: TextView by lazy { findViewById(R.id.ttPhone) }
    private val button2: Button by lazy { findViewById(R.id.button2) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val phone ="+7" + intent.getStringExtra("phone").toString()
        ttPhone.text = phone

        button2.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: $phone")
            startActivity(intent)

        }

        val tvHelloWord = findViewById<TextView>(R.id.tvHelloWord)
        tvHelloWord.setOnClickListener{
            setResult(
                Activity.RESULT_OK, Intent().apply {
                  putExtra("result","tvHelloWord.text")
                }
            )
            finish()

        }

    }
}


