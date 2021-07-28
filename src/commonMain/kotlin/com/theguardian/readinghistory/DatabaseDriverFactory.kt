package com.theguardian.readinghistory

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

class ReadingHistoryDatabaseFactory(private val driverFactory: DatabaseDriverFactory) {
    fun getDatabase(): ReadingHistory {
        return ReadingHistory(driverFactory.createDriver())
    }
}