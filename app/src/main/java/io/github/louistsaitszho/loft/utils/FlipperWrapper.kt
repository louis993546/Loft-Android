package io.github.louistsaitszho.loft.utils

import io.github.louistsaitszho.loft.App

/**
 * Since Flipper is only available in debug builds, this wrapper + allows different builds to init
 * or not init Flipper accordingly.
 */
interface FlipperWrapper {
    fun init(app: App)
}