package com.maciejkozlowski.databases.serialisering

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.lang.Exception

class DiskCache {

    companion object diskcache {

        private var cacheDir: File? = null

        fun init(cacheDirectory: File) {
            if (cacheDir != null) return
            cacheDir = File(cacheDirectory, "DiskCache")
            println("cacheDir = " + cacheDir)
            cacheDir!!.mkdirs()
            try { // skjul lyd og billeder for MP3-afspillere o.lign.
                File(cacheDir, ".nomedia").createNewFile()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }

        @Synchronized
        fun save(filename: String, obj: Serializable?) {
            if (cacheDir == null) {
                Exception("forgot to set cachedir").printStackTrace()
                return
            }
            try {
                val tmpFile = File(cacheDir, filename + "_tmp")
                ObjectOutputStream(FileOutputStream(tmpFile)).use {
                    it.writeObject(obj)
                }
                val file = File(cacheDir, filename)
                file.delete()
                tmpFile.renameTo(file)
            } catch (e: Exception) { e.printStackTrace() }
        }

        fun load(filename: String): Serializable {
            ObjectInputStream(FileInputStream(File(cacheDir, filename))).use {
                val obj = it.readObject()
                return obj as Serializable
            }
        }

        fun delete(filename: String) {
            File(cacheDir, filename).delete()
        }
    }
}
