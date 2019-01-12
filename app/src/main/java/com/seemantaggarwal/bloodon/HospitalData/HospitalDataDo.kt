package com.seemantaggarwal.bloodon.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.seemantaggarwal.bloodon.HospitalData.HospitalData

val DB2_NAME= "HOSPITALS.db"
val DB2_VER= 1
class HospitalDataDo(context: Context?): SQLiteOpenHelper(context, DB2_NAME, null, DB2_VER) {
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.let {
            it.execSQL(HospitalData.CMD_CREATE_TABLE)


        }



    }
}