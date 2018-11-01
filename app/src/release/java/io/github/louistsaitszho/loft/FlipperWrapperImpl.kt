package io.github.louistsaitszho.loft

import io.github.louistsaitszho.loft.utils.FlipperWrapper
import timber.log.Timber

class FlipperWrapperImpl : FlipperWrapper {
    override fun init(app: App) {
        Timber.tag("FlipperWrapperImpl").d("Not release")
    }
}