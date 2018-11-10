package io.github.louistsaitszho.loft.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import timber.log.Timber

class LoftDatabase(applicationContext: Context) {
    private val TAG = "LoftDatabase"

    val db = Room.databaseBuilder(
            applicationContext,
            LoftRoomDatabase::class.java,
            "loft-database"
    ).addCallback(object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Timber.tag(TAG).v("Database onCreate")
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            Timber.tag(TAG).v("Database onOpen")
        }
    })
            .fallbackToDestructiveMigration()   //TODO remove it as soon as applicable
            .build()

    //TODO methods to convert dao return type to domain model data types
}