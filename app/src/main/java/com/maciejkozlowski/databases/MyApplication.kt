package com.maciejkozlowski.databases

import android.app.Application
import androidx.room.Room
import com.maciejkozlowski.databases.objectbox.MyObjectBox
import com.maciejkozlowski.databases.room.CityRoomDatabase
import io.objectbox.BoxStore
import io.realm.Realm

/**
 * Created by Maciej Kozłowski on 01.05.17.
 */
class MyApplication : Application() {

    lateinit var boxStore: BoxStore private set

    lateinit var realm: Realm private set

    lateinit var room: CityRoomDatabase private set

    override fun onCreate() {
        super.onCreate()
        boxStore = MyObjectBox.builder().androidContext(this).build()

        Realm.init(this)
        realm = Realm.getDefaultInstance()

        room = Room.databaseBuilder(this, CityRoomDatabase::class.java, "room").build()
    }
}
