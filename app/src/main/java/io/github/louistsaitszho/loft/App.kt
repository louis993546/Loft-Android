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

import android.app.Application
import android.os.StrictMode
import com.jakewharton.threetenabp.AndroidThreeTen
import io.github.louistsaitszho.loft.api.LoftApiImpl
import io.github.louistsaitszho.loft.api.Module.Companion.apiModule
import io.github.louistsaitszho.loft.chat.ChatRepository
import io.github.louistsaitszho.loft.chat.ChatRepositoryImpl
import io.github.louistsaitszho.loft.chat.ChatViewModel
import io.github.louistsaitszho.loft.common.Module.Companion.commonModule
import io.github.louistsaitszho.loft.common.keyValueStore.KeyValueStore
import io.github.louistsaitszho.loft.main.MainRepository
import io.github.louistsaitszho.loft.main.MainRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesRepository
import io.github.louistsaitszho.loft.notes.NotesRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesViewModel
import io.github.louistsaitszho.loft.onboarding.Module.Companion.onboardingModule
import io.github.louistsaitszho.loft.splash.SplashRepository
import io.github.louistsaitszho.loft.splash.SplashRepositoryImpl
import io.github.louistsaitszho.loft.splash.SplashViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupStrictMode()
        Timber.plant(getTree())
        AndroidThreeTen.init(this)
        startKoin(
                context = this,
                modules = listOf(commonModule, apiModule, onboardingModule, mainModule, appModule),
                logger = TimberKoinLogger()
        )
    }

    private fun setupStrictMode() {
        if (BuildConfig.DEBUG) {
            //TODO is threadPolicy still relevant with coroutine since it actually don't block the thread?
//            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
//                    .detectAll()
//                    .penaltyLog()
//                    .penaltyDeath()
//                    .build()
//            )
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .setClassInstanceLimit(MainRepositoryImpl::class.java, 1)
                    .setClassInstanceLimit(NotesRepositoryImpl::class.java, 1)
                    .setClassInstanceLimit(ChatRepositoryImpl::class.java, 1)
                    .setClassInstanceLimit(SplashRepositoryImpl::class.java, 1)
                    .setClassInstanceLimit(ChatRepositoryImpl::class.java, 1)
                    .setClassInstanceLimit(LoftApiImpl::class.java, 1)
                    .setClassInstanceLimit(KeyValueStore::class.java, 1)
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
        }
    }

    //TODO get the appropriate tree accordingly
    private fun getTree(): Timber.Tree = Timber.DebugTree()
}

/**
 * For the main module
 */
val mainModule = module {
    single<MainRepository> { MainRepositoryImpl() }
    single<NotesRepository> { NotesRepositoryImpl(api = get()) }
    single<ChatRepository> { ChatRepositoryImpl() }

    viewModel { NotesViewModel(repository = get()) }
    viewModel { ChatViewModel(repository = get()) }
}

/**
 * The app module: pretty much just splash
 */
val appModule = module {
    single<SplashRepository> { SplashRepositoryImpl(sharedPreference = get()) }

    viewModel { SplashViewModel(repository = get()) }
}