package io.github.louistsaitszho.loft

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import io.github.louistsaitszho.loft.joining.JoiningViewModel
import io.github.louistsaitszho.loft.notes.NotesRepository
import io.github.louistsaitszho.loft.notes.NotesRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(getTree())
        AndroidThreeTen.init(this)
        startKoin(this, listOf(appModule))
    }

    //TODO get the appropriate tree accordingly
    private fun getTree(): Timber.Tree = Timber.DebugTree()
}

val appModule = module {
    single<NotesRepository> { NotesRepositoryImpl() }
    viewModel { JoiningViewModel() }
    viewModel { NotesViewModel(get()) }
}