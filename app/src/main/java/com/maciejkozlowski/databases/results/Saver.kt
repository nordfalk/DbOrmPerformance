package com.maciejkozlowski.databases.results

import android.os.Environment
import android.util.Log

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.StringBuilder


/**
 * Created by Maciej on 2017-05-10.
 */

class Saver {

    private var outputStream: FileOutputStream? = null
    private var outputStreamWriter: StringBuilder? = null
    private var opened: Boolean = false

    fun open() {
        if (!opened) {
            try {
                val file = File(Environment.getExternalStorageDirectory(), FILE_NAME)
                if (file.exists()) {
                    file.delete()
                }

                outputStream = FileOutputStream(file)
                outputStreamWriter = StringBuilder()
                opened = true
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }

    fun write(data: String) {
        outputStreamWriter!!.append(data)
        if (opened) {
            try {
                outputStream!!.write(data.toByteArray())
            } catch (ex: Exception) {
                ex.printStackTrace()
            }

        } else {
            Log.e(TAG, "NOT OPENED")
        }
    }

    fun close() {
        if (opened) {
            try {
                outputStream!!.close()
                opened = false
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        Log.e(TAG, outputStreamWriter.toString())
    }

    fun save(resultSet: ResultSet) {
        open()

        saveResult(resultSet.creating)
        saveResult(resultSet.reading)
        saveResult(resultSet.deleting)
        saveResult(resultSet.updating)

        close()
    }

    private fun saveResult(result: Result) {
        write(result.type + NEW_LINE)
        for (type in TestConstants.TYPES) {
            for (size in TestConstants.SIZES) {
                val key = size.toString() + "-" + type
                val times = result.times[key]
                write(key + SEPARATOR)
                write(times!!.average().toString() + SEPARATOR)
                write(NEW_LINE)
            }
            write(NEW_LINE)
        }
        write(NEW_LINE)
        write(NEW_LINE)
    }

    companion object {
        const val FILE_NAME = "results.csv"
        const val TAG = "###"
        const val SEPARATOR = ";"
        const val NEW_LINE = "\n"
    }
}
