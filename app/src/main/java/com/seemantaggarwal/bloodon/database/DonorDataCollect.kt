package com.seemantaggarwal.bloodon.database

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.seemantaggarwal.bloodon.R
import kotlinx.android.synthetic.main.activity_donor_data_collect.*

class DonorDataCollect : AppCompatActivity() {
    val Donor = ArrayList<DonorClass>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_data_collect)
        Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG).show()
        val db=DonorDatatodo(this).writableDatabase
        fun refreshDonor() {
            Donor.clear()
            Donor.addAll(DonorData.getDonor(db))

        }
        refreshDonor()


        btnAddData.setOnClickListener() {
            val newTask = DonorClass(etFN.text.toString(),
                    etLN.text.toString(),
                    etPhno.text.toString(), etBG.text.toString())
            val id = DonorData.addDonor(db, newTask)
            refreshDonor()
        }


    }
}





