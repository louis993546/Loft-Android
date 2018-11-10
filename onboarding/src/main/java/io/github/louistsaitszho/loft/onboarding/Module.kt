package io.github.louistsaitszho.loft.onboarding

import io.github.louistsaitszho.loft.onboarding.creation.CreationRepository
import io.github.louistsaitszho.loft.onboarding.creation.CreationRepositoryImpl
import io.github.louistsaitszho.loft.onboarding.creation.CreationViewModel
import io.github.louistsaitszho.loft.onboarding.joining.JoiningViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class Module {
    companion object {
        val onboardingModule = module {
            single<CreationRepository> { CreationRepositoryImpl(get(), get()) }

            viewModel { JoiningViewModel() }
            viewModel { CreationViewModel(repository = get()) }
        }
    }
}