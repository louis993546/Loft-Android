package io.github.louistsaitszho.loft

import android.app.Application
import android.os.StrictMode
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import com.jakewharton.threetenabp.AndroidThreeTen
import io.github.louistsaitszho.loft.common.Module.Companion.commonModule
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
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupStrictMode()
        Timber.plant(getTree())
        AndroidThreeTen.init(this)
        setupFlipper()
        startKoin(this, listOf(commonModule, onboardingModule, mainModule, appModule))
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

    private fun setupFlipper() {
        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            AndroidFlipperClient.getInstance(this).run {
                addPlugin(InspectorFlipperPlugin(this@App, DescriptorMapping.withDefaults()))
                addPlugin(NetworkFlipperPlugin())
                start()
            }
        }
    }
}

/**
 * For the onboarding module
 * TODO move it to right app module once it has been modularize
 */
val onboardingModule = module {
    single<CreationRepository> { CreationRepositoryImpl(api = get()) }

    viewModel { JoiningViewModel() }
    viewModel { CreationViewModel(repository = get()) }
}

/**
 * For the main module
 * TODO move it to right app module once it has been modularize
 */
val mainModule = module {
    single<MainRepository> { MainRepositoryImpl() }
    single<NotesRepository> { NotesRepositoryImpl(api = get()) }

    viewModel { NotesViewModel(repository = get()) }
}

/**
 * The app module: pretty much just splash
 */
val appModule = module {
    single<SplashRepository> { SplashRepositoryImpl(sharedPreference = get()) }

    viewModel { SplashViewModel(repository = get()) }
}