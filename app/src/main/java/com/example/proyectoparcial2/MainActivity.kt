package com.example.proyectoparcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_News = findViewById<Button>(R.id.btn_News)
        val btn_Movies = findViewById<Button>(R.id.btn_Movies)

        btn_News.setOnClickListener(this)
        btn_Movies.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when(view.id){
            R.id.btn_News-> Intent(this, News::class.java)
            R.id.btn_Movies -> Intent(this, Movies::class.java)
            else -> throw IllegalArgumentException("Invalid Button")
        }
        startActivity(intent)
    }
}