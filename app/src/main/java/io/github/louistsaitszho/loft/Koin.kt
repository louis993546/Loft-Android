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

import io.github.louistsaitszho.loft.chat.ChatRepository
import io.github.louistsaitszho.loft.chat.ChatRepositoryImpl
import io.github.louistsaitszho.loft.chat.ChatViewModel
import io.github.louistsaitszho.loft.events.EventsRepository
import io.github.louistsaitszho.loft.events.EventsRepositoryImpl
import io.github.louistsaitszho.loft.events.EventsViewModel
import io.github.louistsaitszho.loft.main.MainRepository
import io.github.louistsaitszho.loft.main.MainRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesRepository
import io.github.louistsaitszho.loft.notes.NotesRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesViewModel
import io.github.louistsaitszho.loft.splash.SplashRepository
import io.github.louistsaitszho.loft.splash.SplashRepositoryImpl
import io.github.louistsaitszho.loft.splash.SplashViewModel
import io.github.louistsaitszho.loft.tasks.TasksRepository
import io.github.louistsaitszho.loft.tasks.TasksRepositoryImpl
import io.github.louistsaitszho.loft.tasks.TasksViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.log.Logger
import timber.log.Timber

/**
 * A very simple adapter that teaches Koin how to log to through Timber
 */
class TimberKoinLogger : Logger {
    private val tag = "TimberKoin"

    override fun debug(msg: String) {
        Timber.tag(tag).d(msg)
    }

    override fun err(msg: String) {
        Timber.tag(tag).e(msg)
    }

    override fun info(msg: String) {
        Timber.tag(tag).i(msg)
    }
}

/**
 * For the main module
 */
val mainModule = module {
    single<MainRepository> { MainRepositoryImpl() }
    single<NotesRepository> { NotesRepositoryImpl(api = get()) }
    single<ChatRepository> { ChatRepositoryImpl() }
    single<TasksRepository> { TasksRepositoryImpl() }
    single<EventsRepository> { EventsRepositoryImpl(api = get()) }

    viewModel { NotesViewModel(repository = get()) }
    viewModel { ChatViewModel(repository = get()) }
    viewModel { TasksViewModel(repository = get()) }
    viewModel { EventsViewModel(repository = get()) }
}

/**
 * The app module: pretty much just splash
 */
val appModule = module {
    single { ReleaseTree(androidApplication()) }
    single<SplashRepository> { SplashRepositoryImpl(sharedPreference = get()) }

    viewModel { SplashViewModel(repository = get()) }
}