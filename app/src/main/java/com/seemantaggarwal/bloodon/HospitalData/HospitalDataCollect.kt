package com.seemantaggarwal.bloodon.HospitalData

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.seemantaggarwal.bloodon.R
import com.seemantaggarwal.bloodon.database.HospitalDataDo
import com.seemantaggarwal.bloodon.recieverDatas.HospitalClass
import kotlinx.android.synthetic.main.activity_hospital_data_collect.*

class HospitalDataCollect : AppCompatActivity() {
    val Receiver = ArrayList<HospitalClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_data_collect)
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show()
        val db= HospitalDataDo(this).writableDatabase
        fun refreshReceiver() {
            Receiver.clear()
            Receiver.addAll(HospitalData.getReceiver(db))

        }
        refreshReceiver()


        btnAddData.setOnClickListener() {
            val newTask = HospitalClass(etHN.text.toString(),
                    etADD.text.toString(),
                    etPhno.text.toString()
            )
            val id = HospitalData.addReceiver(db, newTask)
            refreshReceiver()
        }
    }
}
