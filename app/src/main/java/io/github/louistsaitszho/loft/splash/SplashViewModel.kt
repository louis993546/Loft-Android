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
package io.github.louistsaitszho.loft.splash

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.github.louistsaitszho.loft.common.ScopedViewModel
import kotlinx.coroutines.launch

class SplashViewModel(private val repository: SplashRepository) : ScopedViewModel() {
    private val _sceneAfterSplash = MutableLiveData<SceneAfterSplash>()
    val sceneAfterSplash: LiveData<SceneAfterSplash>
        get() = _sceneAfterSplash

    fun findNextScene() {
        launch {
            _sceneAfterSplash.postValue(when (repository.isSignedIn()) {
                true -> SceneAfterSplash.MAIN
                false -> SceneAfterSplash.ONBOARDING
            })
        }
    }

    enum class SceneAfterSplash {
        ONBOARDING,
        MAIN
    }
}