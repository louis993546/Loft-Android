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
package io.github.louistsaitszho.loft.api.dto

import com.squareup.moshi.JsonClass

/**
 * TODO link to JSON API doc of Attributes
 */
sealed class Attributes

@JsonClass(generateAdapter = true)
data class NoteAttributes(
        val title: String,
        val description: String,
        val createdAt: String,      //TODO time
        val content: String
) : Attributes()

@JsonClass(generateAdapter = true)
data class TaskAttributes(
        val createdAt: String,      //TODO time
        val title: String,
        val dueDate: String         //TODO time
) : Attributes()

@JsonClass(generateAdapter = true)
data class MemberAttributes(
        val name: String,
        val phone: String,
        val email: String,
        val approvedAt: String      //TODO time
) : Attributes()

@JsonClass(generateAdapter = true)
data class EventAttributes(
        val title: String,
        val createdAt: String,      //TODO time
        val startTime: String,      //TODO time
        val endTime: String         //TODO time
) : Attributes()

//TODO need to find a way to convert it to null essentially
object NoAttributes : Attributes()