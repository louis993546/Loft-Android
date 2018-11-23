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

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import io.github.louistsaitszho.loft.database.entity.MessageEntity
import io.github.louistsaitszho.loft.database.entity.NoteEntity
import io.github.louistsaitszho.loft.database.entity.TaskEntity
import io.github.louistsaitszho.loft.database.typeConverter.LocalDateConverter
import io.github.louistsaitszho.loft.database.typeConverter.OffsetDateTimeConverter
import io.github.louistsaitszho.loft.database.typeConverter.UuidTypeConverter

@Database(
        entities = [MessageEntity::class, NoteEntity::class, TaskEntity::class],
        version = 1,
        exportSchema = true
)
@TypeConverters(UuidTypeConverter::class, OffsetDateTimeConverter::class, LocalDateConverter::class)
abstract class LoftRoomDatabase : RoomDatabase()