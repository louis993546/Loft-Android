package io.github.louistsaitszho.loft

import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlin.coroutines.experimental.CoroutineContext

/**
 * This class introduce coroutine to ViewModel and allows coroutine to be
 * - start
 * - cancel automatically
 */
abstract class ScopedViewModel : ViewModel(), CoroutineScope {
    protected var job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}