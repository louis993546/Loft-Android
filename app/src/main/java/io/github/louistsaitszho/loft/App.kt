package io.github.louistsaitszho.loft

import android.app.Application
import android.os.StrictMode
import com.jakewharton.threetenabp.AndroidThreeTen
import io.github.louistsaitszho.loft.joining.JoiningViewModel
import io.github.louistsaitszho.loft.localStorage.SharedPreferenceManager
import io.github.louistsaitszho.loft.localStorage.SharedPreferenceManagerImpl
import io.github.louistsaitszho.loft.notes.NotesRepository
import io.github.louistsaitszho.loft.notes.NotesRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesViewModel
import io.github.louistsaitszho.loft.splash.SplashRepository
import io.github.louistsaitszho.loft.splash.SplashRepositoryImpl
import io.github.louistsaitszho.loft.splash.SplashViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        setupStrictMode()
        super.onCreate()
        Timber.plant(getTree())
        AndroidThreeTen.init(this)
        startKoin(this, listOf(appModule))
    }

    private fun setupStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
            StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build()
            )
        }
    }

    //TODO get the appropriate tree accordingly
    private fun getTree(): Timber.Tree = Timber.DebugTree()
}

val appModule = module {
    single<SharedPreferenceManager> { SharedPreferenceManagerImpl(androidContext()) }
    single<NotesRepository> { NotesRepositoryImpl() }
    single<SplashRepository> { SplashRepositoryImpl(get()) }
    viewModel { JoiningViewModel() }
    viewModel { NotesViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}