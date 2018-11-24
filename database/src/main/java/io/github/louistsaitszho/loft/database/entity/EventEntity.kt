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
package io.github.louistsaitszho.loft.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import io.github.louistsaitszho.loft.database.entity.EventEntity.Companion.TABLE_NAME
import org.threeten.bp.OffsetDateTime
import java.util.*

/**
 *
 */
@Entity(tableName = TABLE_NAME)
data class EventEntity(
        @PrimaryKey @ColumnInfo(name = COLUMN_ID) val id: UUID,
        @ColumnInfo(name = COLUMN_START_TIME) val startTime: OffsetDateTime,
        @ColumnInfo(name = COLUMN_END_TIME) val endTime: OffsetDateTime,
        @ColumnInfo(name = COLUMN_TITLE) val title: String,
        @ColumnInfo(name = COLUMN_DESCRIPTION) val descriptor: String
        //TODO is CommonMark a data type?
) {
    companion object {
        const val TABLE_NAME = "events"
        const val COLUMN_ID = "event_id"
        const val COLUMN_START_TIME = "start_time"
        const val COLUMN_END_TIME = "end_time"
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
    }
}