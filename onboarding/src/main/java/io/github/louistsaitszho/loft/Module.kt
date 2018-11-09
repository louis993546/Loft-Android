package io.github.louistsaitszho.loft

import io.github.louistsaitszho.loft.creation.CreationRepository
import io.github.louistsaitszho.loft.creation.CreationRepositoryImpl
import io.github.louistsaitszho.loft.creation.CreationViewModel
import io.github.louistsaitszho.loft.joining.JoiningViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class Module {
    companion object {
        val onboardingModule = module {
            single<CreationRepository> { CreationRepositoryImpl(api = get()) }

            viewModel { JoiningViewModel() }
            viewModel { CreationViewModel(repository = get()) }
        }
    }
}