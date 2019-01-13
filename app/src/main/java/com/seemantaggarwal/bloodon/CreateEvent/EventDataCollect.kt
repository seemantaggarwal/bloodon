package com.seemantaggarwal.bloodon.CreateEvent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.seemantaggarwal.bloodon.HospitalData.HospitalData
import com.seemantaggarwal.bloodon.R
import com.seemantaggarwal.bloodon.database.HospitalDataDo
import kotlinx.android.synthetic.main.activity_create_event.*
import kotlinx.android.synthetic.main.activity_hospital_data_collect.*

class EventDataCollect : AppCompatActivity() {

    val Receiver = ArrayList<EventClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_data_collect)
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show()
        val db= HospitalDataDo(this).writableDatabase
        fun refreshReceiver() {
            Receiver.clear()
            Receiver.addAll(EventData.getReceiver(db))

        }
        refreshReceiver()


        btnAddData.setOnClickListener() {
            val newTask = EventClass(etVen.text.toString(),
                    etDate.text.toString(),
                    etTime.text.toString(),
                    Phn.text.toString()
            )
            val id = HospitalData.addReceiver(db, newTask)
            refreshReceiver()
        }
    }
}