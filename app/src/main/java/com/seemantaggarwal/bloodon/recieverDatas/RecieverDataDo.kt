package com.seemantaggarwal.bloodon.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DB1_NAME= "RECEIVERS.db"
val DB1_VER= 1
class RecieverDatatodo(context: Context?): SQLiteOpenHelper(context, DB1_NAME, null, DB1_VER) {
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.let {
            it.execSQL(RecieverData.CMD_CREATE_TABLE)


        }



    }
}