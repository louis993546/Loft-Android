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
package io.github.louistsaitszho.loft

import org.koin.log.Logger
import timber.log.Timber

/**
 * A very simple adapter that teaches Koin how to log to through Timber
 */
class TimberKoinLogger : Logger {
    @Suppress("PrivatePropertyName")
    private val TAG = "TimberKoin"

    override fun debug(msg: String) {
        Timber.tag(TAG).d(msg)
    }

    override fun err(msg: String) {
        Timber.tag(TAG).e(msg)
    }

    override fun info(msg: String) {
        Timber.tag(TAG).i(msg)
    }
}