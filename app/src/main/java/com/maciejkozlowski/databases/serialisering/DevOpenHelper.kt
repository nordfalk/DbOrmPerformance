package com.maciejkozlowski.databases.serialisering

import android.content.Context


class DevOpenHelper(context: Context) {

    companion object {
        private const val DATABASE_NAME = "cities-dao.db"
    }
    init {
        DiskCache.init(context.filesDir)
    }
}
