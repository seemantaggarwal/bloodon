package com.seemantaggarwal.bloodon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.seemantaggarwal.bloodon.R.*
import kotlinx.android.synthetic.main.activity_introduction.*
import kotlinx.android.synthetic.main.activity_main.*

class introduction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
        btnNext.setOnClickListener(){
                 val actIntent= Intent(this, MainActivity::class.java)
                startActivity(actIntent)
        }
    }
}
