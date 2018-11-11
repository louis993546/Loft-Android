/*
 * This file is part of Loft Android Client.

 * Loft Android Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Loft Android Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Loft Android Client.  If not, see <https://www.gnu.org/licenses/>.
 */
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