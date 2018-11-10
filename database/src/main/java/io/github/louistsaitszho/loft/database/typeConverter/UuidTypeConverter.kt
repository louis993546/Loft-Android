package io.github.louistsaitszho.loft.database.typeConverter

import android.arch.persistence.room.TypeConverter
import java.util.*

class UuidTypeConverter {
    @TypeConverter
    fun toString(uuid: UUID?): String? = uuid?.toString()

    @TypeConverter
    fun toUuid(string: String?): UUID? = UUID.fromString(string)
}