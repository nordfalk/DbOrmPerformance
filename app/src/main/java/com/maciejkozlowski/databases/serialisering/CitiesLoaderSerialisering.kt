package com.maciejkozlowski.databases.serialisering


import android.content.Context

import com.maciejkozlowski.databases.BaseLoader
import com.maciejkozlowski.databases.Timings
import com.maciejkozlowski.databases.results.ResultSet

/**
 * Created by Maciej Kozłowski on 01.05.17.
 */
class CitiesLoaderSerialisering : BaseLoader<CityDao>() {
    private val DATABASE_NAME = "cities-serialiseret.ser"

    fun execute(context: Context, resultSet: ResultSet, size: Int) {

        DiskCache.init(context.filesDir)

        val cities = readFromFile(context, CITIES_CSV, size)

        logger.start()
        DiskCache.save(DATABASE_NAME, cities)
        logger.logTime(resultSet.creating, size)

        logger.start()
        val cityDaos = DiskCache.load(DATABASE_NAME) as ArrayList<CityDao>
        logger.logTime(resultSet.reading, size)

        logger.start()
        for (i in cityDaos.indices) {
            cityDaos[i].name = i.toString()
        }
        DiskCache.save(DATABASE_NAME, cities)
        logger.logTime(resultSet.updating, size)

        logger.start()
        cities.clear()
        DiskCache.save(DATABASE_NAME, cities)
        logger.logTime(resultSet.deleting, size)
    }

    override fun create(id: Long?, name: String, latitude: Double?, longitude: Double?): CityDao {
        return CityDao(id!!, name, latitude!!, longitude!!)
    }

    override fun createTimingLogger(): Timings {
        return Timings(TAG)
    }

    companion object {

        const val TAG = "serialisering"
    }
}
