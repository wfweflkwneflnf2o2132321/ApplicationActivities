package com.example.applicationactivities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object{
        const val SECOND_ACTIVITY_DATA = 1
    }
    private val tvPhone: EditText by lazy { findViewById(R.id.tvPhone) }
    private val Ok: Button by lazy { findViewById(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvHello = findViewById<TextView>(R.id.tvHello)

        tvHello.setOnClickListener{
        startActivityForResult(Intent(this, SecondActivity::class.java), SECOND_ACTIVITY_DATA)
        }


        Ok.setOnClickListener {
            val phone = tvPhone.text.toString()
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            Intent(intent)
            // в ключ username пихаем текст из первого текстового поля
            intent.putExtra("phone", phone)
            startActivity(intent)
        }



        Log.d("TAG","onCreate")
    }


    override fun onStart() {
        super.onStart()
        Log.d("TAG","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG","onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.d("TAG","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG","onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG","onDestroy")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            SECOND_ACTIVITY_DATA ->{
                if(resultCode == Activity.RESULT_OK){
                    Log.d("TAG 1", "${data?.getStringExtra("result")}")
                }
            }
        }

    }
}