package com.seemantaggarwal.bloodon.CreateEvent

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.seemantaggarwal.bloodon.database.DonorClass

class EventData {
    companion object {
        val TABLE_NAME = "DONORS"
        val CMD_CREATE_TABLE = """ CREATE TABLE IF NOT EXISTS ${TABLE_NAME} (
                ${Columns.PLACE} TEXT ,
                ${Columns.DATE} TEXT,
                ${Columns.TIME} TEXT,
                ${Columns.CONTACT} TEXT

            );
            """.trimIndent()

        fun addDonor(db: SQLiteDatabase, data: DonorClass): Long {
            val row = ContentValues()
            row.put(Columns.PLACE, data.place)
            row.put(Columns.DATE, data.date)
            row.put(Columns.TIME, data.time)
            row.put(Columns.CONTACT, data.contact)
            return db.insert(TABLE_NAME, null, row)


        }

        fun getDonor(db: SQLiteDatabase): ArrayList<DonorClass> {
            val tasks = ArrayList<DonorClass>()
            val cursor = db.query(
                    TABLE_NAME,
                    arrayOf(Columns.PLACE, Columns.DATE, Columns.TIME, Columns.CONTACT),
                    null, null,
                    null, null,
                    null
            )
            val fnCol = cursor.getColumnIndex(Columns.PLACE)
            val lnCol = cursor.getColumnIndex(Columns.DATE)
            val telCol = cursor.getColumnIndex(Columns.TIME)
            val bgCol = cursor.getColumnIndex(Columns.CONTACT)
            while (cursor.moveToNext()) {
                val rowTask = DonorClass(
                        cursor.getString(fnCol),
                        cursor.getString(lnCol),
                        cursor.getString(telCol),
                        cursor.getString(bgCol)
                )
                tasks.add(rowTask)

            }
            return tasks
        }
    }

    object Columns {
        val PLACE = "FIRSTNAME"
        val DATE = "LASTNAME"
        val TIME = "TELNUM"
        val CONTACT = "BLOODGROUP"
    }
}