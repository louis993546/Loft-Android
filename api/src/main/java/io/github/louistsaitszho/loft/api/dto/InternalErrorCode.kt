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

enum class InternalErrorCode {
    ERROR_404_LOFT_NOT_FOUND,
    ERROR_404_NOTE_NOT_FOUND,
    ERROR_404_TASK_NOT_FOUND,
    ERROR_404_EVENT_NOT_FOUND,
    ERROR_404_MEMBER_NOT_FOUND,
    ERROR_403_FORBIDDEN,
    ERROR_403_CLIENT_GENERATED_LOFT_ID,
    ERROR_403_CLIENT_GENERATED_NOTE_ID,
    ERROR_403_CLIENT_GENERATED_TASK_ID,
    ERROR_403_CLIENT_GENERATED_EVENT_ID,
    ERROR_403_CLIENT_GENERATED_MEMBER_ID,
    ERROR_410_LOFT_GONE,
    ERROR_410_NOTE_GONE,
    ERROR_410_TASK_GONE,
    ERROR_410_EVENT_GONE,
    ERROR_410_MEMBER_GONE,
    ERROR_400_SORT_NOT_APPLICABLE,
    ERROR_401_UNAUTHORIZED,
    ERROR_405_METHOD_NOT_ALLOW,
    ERROR_406_NOT_ACCEPTABLE,
    ERROR_415_UNSUPPORTED_MEDIA_TYPE,
    ERROR_503_NO_DATABASE_CONNECTION,
    ERROR_504_MAINTENANCE
}