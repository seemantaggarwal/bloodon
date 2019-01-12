package com.seemantaggarwal.bloodon.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DB_NAME= "DONORS.db"
val DB_VER= 1
class DonorDatatodo(context: Context?): SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.let {
            it.execSQL(DonorData.CMD_CREATE_TABLE)


        }



    }
}