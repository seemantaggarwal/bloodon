package com.seemantaggarwal.bloodon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var actIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRec.setOnClickListener(){
            actIntent= Intent(this, DonorLogin::class.java)
            startActivity(actIntent)
        }
        btnHosp.setOnClickListener(){
            actIntent= Intent(this, HospitalLogin::class.java)
            startActivity(actIntent)
        }
        btnDon.setOnClickListener(){
            actIntent= Intent(this, ReceiverLogin::class.java)
            startActivity(actIntent)
        }
    }
    //seemant aggarwal
    //Stuti

}
