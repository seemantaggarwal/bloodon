package com.seemantaggarwal.bloodon.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.seemantaggarwal.bloodon.recieverDatas.ReceiverClass

class RecieverData {
    companion object {
        val TABLE_NAME = "RECEIVERS"
        val CMD_CREATE_TABLE = """ CREATE TABLE IF NOT EXISTS ${TABLE_NAME} (
                ${Columns.FIRSTNAME} TEXT ,
                ${Columns.LASTNAME} TEXT,
                ${Columns.ADDRESS} TEXT,
                ${Columns.TELNUM} TEXT,
                ${Columns.BDGRP} TEXT,
                ${Columns.ANTIGEN} TEXT

            );
            """.trimIndent()

        fun addReceiver(db: SQLiteDatabase, data: ReceiverClass): Long {
            val row = ContentValues()
            row.put(Columns.FIRSTNAME, data.firstname)
            row.put(Columns.LASTNAME, data.lastname)
            row.put(Columns.ADDRESS, data.address)
            row.put(Columns.TELNUM, data.telnum)
            row.put(Columns.BDGRP, data.bloodgroup)
            row.put(Columns.ANTIGEN, data.antigen)
            return db.insert(TABLE_NAME, null, row)


        }

        fun getReceiver(db: SQLiteDatabase): ArrayList<ReceiverClass> {
            val tasks = ArrayList<ReceiverClass>()
            val cursor = db.query(
                    TABLE_NAME,
                    arrayOf(Columns.FIRSTNAME, Columns.LASTNAME, Columns.ADDRESS, Columns.TELNUM, Columns.BDGRP, Columns.ANTIGEN),
                    null, null,
                    null, null,
                    null
            )
            val fnCol = cursor.getColumnIndex(Columns.FIRSTNAME)
            val lnCol = cursor.getColumnIndex(Columns.LASTNAME)
            val addrCol = cursor.getColumnIndex(Columns.ADDRESS)
            val telCol = cursor.getColumnIndex(Columns.TELNUM)
            val bgCol = cursor.getColumnIndex(Columns.BDGRP)
            val antiCol = cursor.getColumnIndex(Columns.ANTIGEN)
            while (cursor.moveToNext()) {
                val rowTask = ReceiverClass(
                        cursor.getString(fnCol),
                        cursor.getString(lnCol),
                        cursor.getString(addrCol),
                        cursor.getString(telCol),
                        cursor.getString(bgCol),
                        cursor.getString(antiCol)

                )
                tasks.add(rowTask)

            }
            return tasks
        }
    }

    object Columns {
        val FIRSTNAME = "FIRSTNAME"
        val LASTNAME = "LASTNAME"
        val ADDRESS = "ADDRESS"
        val TELNUM = "TELNUM"
        val BDGRP = "BLOODGROUP"
        val ANTIGEN = "ANTIGEN"
    }
}