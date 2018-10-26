package io.github.louistsaitszho.loft

import android.app.Application
import android.os.StrictMode
import com.jakewharton.threetenabp.AndroidThreeTen
import io.github.louistasitszho.loft.common.localStorage.SharedPreferenceManager
import io.github.louistasitszho.loft.common.localStorage.SharedPreferenceManagerImpl
import io.github.louistasitszho.loft.common.network.API
import io.github.louistasitszho.loft.common.network.APIImpl
import io.github.louistsaitszho.loft.creation.CreationRepository
import io.github.louistsaitszho.loft.creation.CreationRepositoryImpl
import io.github.louistsaitszho.loft.creation.CreationViewModel
import io.github.louistsaitszho.loft.joining.JoiningViewModel
import io.github.louistsaitszho.loft.main.MainRepository
import io.github.louistsaitszho.loft.main.MainRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesRepository
import io.github.louistsaitszho.loft.notes.NotesRepositoryImpl
import io.github.louistsaitszho.loft.notes.NotesViewModel
import io.github.louistsaitszho.loft.splash.SplashRepository
import io.github.louistsaitszho.loft.splash.SplashRepositoryImpl
import io.github.louistsaitszho.loft.splash.SplashViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupStrictMode()
        Timber.plant(getTree())
        AndroidThreeTen.init(this)
        startKoin(this, listOf(appModule))
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
    single<SharedPreferenceManager> { SharedPreferenceManagerImpl(androidApplication()) }
    single<API> { APIImpl() }

    single<MainRepository> { MainRepositoryImpl() }
    single<CreationRepository> { CreationRepositoryImpl(api = get()) }
    single<NotesRepository> { NotesRepositoryImpl(api = get()) }
    single<SplashRepository> { SplashRepositoryImpl(sharedPreference = get()) }

    viewModel { CreationViewModel(repository = get()) }
    viewModel { JoiningViewModel() }
    viewModel { NotesViewModel(repository = get()) }
    viewModel { SplashViewModel(repository = get()) }
}