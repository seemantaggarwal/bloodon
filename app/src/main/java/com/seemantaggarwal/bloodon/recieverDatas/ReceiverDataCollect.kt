package com.seemantaggarwal.bloodon.recieverDatas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.seemantaggarwal.bloodon.R
import com.seemantaggarwal.bloodon.database.RecieverData
import com.seemantaggarwal.bloodon.database.RecieverDatatodo
import kotlinx.android.synthetic.main.activity_receiver_data_collect2.*

class ReceiverDataCollect : AppCompatActivity() {
    val Receiver = ArrayList<ReceiverClass>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_data_collect2)
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show()
        val db= RecieverDatatodo(this).writableDatabase
        fun refreshReceiver() {
          Receiver.clear()
            Receiver.addAll(RecieverData.getReceiver(db))

        }
        refreshReceiver()


        btnAddData.setOnClickListener() {
            val newTask = ReceiverClass(etFN.text.toString(),
                    etLN.text.toString(), etADD.text.toString(),
                    etPhno.text.toString(), etBG.text.toString(),
                    etAnti.text.toString()
            )
            val id = RecieverData.addReceiver(db, newTask)
            refreshReceiver()
        }


    }
}





