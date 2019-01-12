package com.seemantaggarwal.bloodon.HospitalData

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.seemantaggarwal.bloodon.recieverDatas.HospitalClass


class HospitalData {
    companion object {
        val TABLE_NAME = "HOSPITALS"
        val CMD_CREATE_TABLE = """ CREATE TABLE IF NOT EXISTS ${TABLE_NAME} (
                ${Columns.HOSPITALNAME} TEXT ,
                ${Columns.ADDRESS} TEXT,
                ${Columns.TELNUM} TEXT

            );
            """.trimIndent()

        fun addReceiver(db: SQLiteDatabase, data: HospitalClass): Long {
            val row = ContentValues()
            row.put(Columns.HOSPITALNAME, data.hospitalname)
            row.put(Columns.ADDRESS, data.address)
            row.put(Columns.TELNUM, data.telnum)
            return db.insert(TABLE_NAME, null, row)


        }

        fun getReceiver(db: SQLiteDatabase): ArrayList<HospitalClass> {
            val tasks = ArrayList<HospitalClass>()
            val cursor = db.query(
                    TABLE_NAME,
                    arrayOf(Columns.HOSPITALNAME, Columns.ADDRESS, Columns.TELNUM),
                    null, null,
                    null, null,
                    null
            )
            val hospCol = cursor.getColumnIndex(Columns.HOSPITALNAME)
            val addrCol = cursor.getColumnIndex(Columns.ADDRESS)
            val telCol = cursor.getColumnIndex(Columns.TELNUM)
            while (cursor.moveToNext()) {
                val rowTask = HospitalClass(
                        cursor.getString(hospCol),
                        cursor.getString(addrCol),
                        cursor.getString(telCol)

                )
                tasks.add(rowTask)

            }
            return tasks
        }
    }

    object Columns {
        val HOSPITALNAME = "FIRSTNAME"
        val ADDRESS = "ADDRESS"
        val TELNUM = "TELNUM"

    }
}