package io.github.louistsaitszho.loft.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import io.github.louistsaitszho.loft.database.entity.MessageEntity
import io.github.louistsaitszho.loft.database.typeConverter.UuidTypeConverter

@Database(entities = [MessageEntity::class], version = 1)
@TypeConverters(UuidTypeConverter::class)
abstract class LoftRoomDatabase : RoomDatabase()