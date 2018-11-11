package io.github.louistsaitszho.loft.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "messages")
internal data class MessageEntity(
        @PrimaryKey(autoGenerate = false) var id: UUID,
        @ColumnInfo(name = "message") var message: String
)

