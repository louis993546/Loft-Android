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